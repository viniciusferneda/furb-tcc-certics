package vinicius.ferneda.tcc.certics.view;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import vinicius.ferneda.tcc.certics.business.AvaliacaoBC;
import vinicius.ferneda.tcc.certics.domain.AvaliacaoEntity;
import vinicius.ferneda.tcc.certics.persistence.AvaliacaoDAO;
import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.report.Report;
import br.gov.frameworkdemoiselle.report.Type;
import br.gov.frameworkdemoiselle.report.annotation.Path;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.util.FileRenderer;
import br.gov.frameworkdemoiselle.util.ResourceBundle;

@ViewController
@NextView("./conjuntoEvidencias_edit.jsf")
@PreviousView("./conjuntoEvidencias_list.jsf")
public class ConjuntoEvidenciasListMB extends AbstractListPageBean<AvaliacaoEntity, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private AvaliacaoBC avaliacaoBC;
	@Inject
	private AvaliacaoDAO avaliacaoDAO;
	
	@Inject
	@Path("reports/RelatorioAvaliacaoDetalhado.jasper")
	private Report relatorio;
	@Inject
	private FileRenderer renderer;
	
	@Inject
	private MessageContext messageContext;
	@Inject
	private ResourceBundle bundle;	
	
	@Override
	protected List<AvaliacaoEntity> handleResultList() {
		return this.avaliacaoBC.findAll();
	}
	
	public String exibirRelatorioEvidencias() {
		String avaliacaoIds = null;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			if(avaliacaoIds == null){
				avaliacaoIds = String.valueOf(iter.next());
			}else{
				avaliacaoIds = ","+String.valueOf(iter.next());
			}
		}
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
		return getNextView();
	}
	
	public String exibirRelatorioPendencias() {
		return getNextView();
	}
}