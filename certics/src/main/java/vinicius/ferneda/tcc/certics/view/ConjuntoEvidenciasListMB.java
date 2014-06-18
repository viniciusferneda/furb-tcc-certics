package vinicius.ferneda.tcc.certics.view;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import vinicius.ferneda.tcc.certics.business.AvaliacaoBC;
import vinicius.ferneda.tcc.certics.domain.AvaliacaoEntity;
import vinicius.ferneda.tcc.certics.persistence.AvaliacaoDAO;
import vinicius.ferneda.tcc.certics.reports.ExportarRelatorio;
import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;

@ViewController
@NextView("./conjuntoEvidencias_edit.jsf")
@PreviousView("./conjuntoEvidencias_list.jsf")
public class ConjuntoEvidenciasListMB extends AbstractListPageBean<AvaliacaoEntity, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private AvaliacaoBC avaliacaoBC;
	@Inject
	private AvaliacaoDAO avaliacaoDAO;
	
	@Override
	protected List<AvaliacaoEntity> handleResultList() {
		return this.avaliacaoBC.findAll();
	}
	
	public void exibirRelatorioEvidencias() {
		String avaliacaoIds = null;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			if(avaliacaoIds == null){
				avaliacaoIds = String.valueOf(iter.next());
			}else{
				avaliacaoIds = ","+String.valueOf(iter.next());
			}
		}
		Map<String, Object> mapParametros = new HashMap<String, Object>();
		mapParametros.put("AVA_ID", avaliacaoIds);
		
		ExportarRelatorio relatorio = new ExportarRelatorio("reports/RelatorioAvaliacaoDetalhado.jasper");
		relatorio.exportarRelatorioPdf(mapParametros, (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse(), "Relatório de evidências");
		
		/*
		List<AvaliacaoEntity> lAvaliacoes = avaliacaoDAO.findEvidenciasByAvaliacaoID(avaliacaoIds);
		if(lAvaliacoes != null && !lAvaliacoes.isEmpty()){
			try {
				byte[] buffer = this.relatorio.export(getResultList(), null, Type.PDF);
				this.renderer.render(buffer, FileRenderer.ContentType.PDF, "relatorio.pdf");
			} catch (Exception e) {
				messageContext.add(e.getMessage(), e);
			}
		}else{
			messageContext.add(bundle.getString("label.senha.invalida"));
		}
		return getNextView();*/
	}
	
	public String exibirRelatorioPendencias() {
		return getNextView();
	}
}