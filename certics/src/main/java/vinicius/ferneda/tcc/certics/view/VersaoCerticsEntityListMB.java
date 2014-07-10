package vinicius.ferneda.tcc.certics.view;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import vinicius.ferneda.tcc.certics.business.VersaoCerticsEntityBC;
import vinicius.ferneda.tcc.certics.domain.VersaoCerticsEntity;
import vinicius.ferneda.tcc.certics.reports.ExportarRelatorio;

@ViewController
@NextView("./versaoCerticsEntity_edit.jsf")
@PreviousView("./versaoCerticsEntity_list.jsf")
public class VersaoCerticsEntityListMB extends AbstractListPageBean<VersaoCerticsEntity, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private VersaoCerticsEntityBC versaoCerticsEntityBC;
	
	@Override
	protected List<VersaoCerticsEntity> handleResultList() {
		return this.versaoCerticsEntityBC.findAll();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				versaoCerticsEntityBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}
	
	public void exibirRelatorioResultadoEsperadoPorVersao() {
		String versaoIds = null;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			if(getSelection().get(id)){
				if(versaoIds == null){
					versaoIds = String.valueOf(id);
				}else{
					versaoIds += ","+String.valueOf(id);
				}
			}
		}
		Map<String, Object> mapParametros = new HashMap<String, Object>();
		mapParametros.put("VCE_ID", versaoIds);
		ExportarRelatorio relatorio = new ExportarRelatorio("reports/relatorioresultadoesperadoporversao/RelatorioResultadoEsperadoPorVersao.jasper");
		relatorio.exportarRelatorioPdf(mapParametros, (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse(), "Relatorio_Resultado_Esperado");
	}

}