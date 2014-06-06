package vinicius.ferneda.tcc.certics.view;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import vinicius.ferneda.tcc.certics.business.AvaliacaoBC;
import vinicius.ferneda.tcc.certics.domain.AvaliacaoEntity;
import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.report.Report;
import br.gov.frameworkdemoiselle.report.Type;
import br.gov.frameworkdemoiselle.report.annotation.Path;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.util.FileRenderer;

@ViewController
@NextView("./conjuntoEvidencias_edit.jsf")
@PreviousView("./conjuntoEvidencias_list.jsf")
public class ConjuntoEvidenciasListMB extends AbstractListPageBean<AvaliacaoEntity, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private AvaliacaoBC avaliacaoBC;
	
	@Inject
	@Path("reports/clientes.jasper")
	private Report relatorio;
	
	@Inject
	private FileRenderer renderer;
	
	@Override
	protected List<AvaliacaoEntity> handleResultList() {
		return this.avaliacaoBC.findAll();
	}

	@Inject
	private MessageContext messageContext;
	
	public String exibirRelatorioGeral() {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("T\u00EDtulo", "Listagem de Clientes");
		try {
			byte[] buffer = this.relatorio.export(getResultList(), param, Type.PDF);
			this.renderer.render(buffer, FileRenderer.ContentType.PDF, "relatorio.pdf");
		} catch (Exception e) {
			messageContext.add(e.getMessage(), e);
		}
		return getNextView();
	}
}