
package vinicius.ferneda.tcc.certics.view;

import java.util.List;

import javax.faces.model.SelectItem;
import javax.inject.Inject;

import vinicius.ferneda.tcc.certics.business.AreaCompetenciaBC;
import vinicius.ferneda.tcc.certics.business.ResultadoEsperadoBC;
import vinicius.ferneda.tcc.certics.domain.AreaCompetencia;
import vinicius.ferneda.tcc.certics.domain.ResultadoEsperado;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;

@ViewController
@PreviousView("./resultadoEsperado_list.jsf")
public class ResultadoEsperadoEditMB extends AbstractEditPageBean<ResultadoEsperado, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private ResultadoEsperadoBC resultadoEsperadoBC;
	

	@Inject
	private AreaCompetenciaBC areaCompetenciaBC;
	
	public List<AreaCompetencia> getAreaCompetenciaList(){
		return areaCompetenciaBC.findAll();
	}
			
	public List<SelectItem> getVersaoCertics() {
		return resultadoEsperadoBC.getEnumVersaoCertics();
	}
	
	@Override
	@Transactional
	public String delete() {
		this.resultadoEsperadoBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		this.resultadoEsperadoBC.insert(this.getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.resultadoEsperadoBC.update(this.getBean());
		return getPreviousView();
	}
	
	@Override
	protected ResultadoEsperado handleLoad(Long id) {
		return this.resultadoEsperadoBC.load(id);
	}	
}