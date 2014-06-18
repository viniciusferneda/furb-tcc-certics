package vinicius.ferneda.tcc.certics.reports;

import java.io.ByteArrayOutputStream;
import java.sql.Connection;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRPdfExporterParameter;
import net.sf.jasperreports.engine.util.JRLoader;
import vinicius.ferneda.tcc.certics.util.ConnectionPool;
import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.report.internal.implementation.ReportImpl;
import br.gov.frameworkdemoiselle.util.ResourceBundle;

public class ExportarRelatorio extends ReportImpl{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ExportarRelatorio(String path) {
		super(path);
	}
	
	@Inject
	private MessageContext messageContext;
	@Inject
	private ResourceBundle bundle;
	
	public void exportarRelatorioPdf(Map<String, Object> parametros, HttpServletResponse response, String nomeRelatorio) {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		if (classLoader == null) {
			classLoader = this.getClass().getClassLoader();
		}
		Connection conn = null;
		try {
			conn = ConnectionPool.getConnection(ConnectionPool.ALIAS_CERTICS);
			
			JasperReport relatorio = (JasperReport) JRLoader.loadObject(classLoader.getResourceAsStream(getPath()));
			JasperPrint jPrint = JasperFillManager.fillReport(relatorio, parametros, conn);
			
			ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
			JRPdfExporter exporterPDF = new JRPdfExporter();
			exporterPDF.setParameter(JRExporterParameter.JASPER_PRINT, jPrint);
			exporterPDF.setParameter(JRExporterParameter.OUTPUT_STREAM, byteArrayOutputStream);
			exporterPDF.setParameter(JRPdfExporterParameter.IS_CREATING_BATCH_MODE_BOOKMARKS, Boolean.TRUE);
			exporterPDF.setParameter(JRExporterParameter.IGNORE_PAGE_MARGINS, Boolean.TRUE);
			exporterPDF.exportReport();
			
			final ServletOutputStream out = response.getOutputStream();
			response.setHeader("Content-Type", "application/pdf; name=\"" + nomeRelatorio + ".pdf\"");
			response.setHeader("Content-Disposition", "attachment; filename=\"" + nomeRelatorio + ".pdf\"");
			out.write(byteArrayOutputStream.toByteArray());
			out.flush();
			out.close();
		} catch (Exception e) {
			messageContext.add(e.getMessage(), e);
			messageContext.add(bundle.getString("exportarrelatorio.error.geracaopdf"));
		} finally {
			ConnectionPool.closeConnection(conn, this.getClass());
		}
	}

}
