
package vinicius.ferneda.tcc.certics.view;

import java.util.List;

import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.inject.Inject;

import vinicius.ferneda.tcc.certics.business.AreaCompetenciaBC;
import vinicius.ferneda.tcc.certics.domain.AreaCompetencia;
import vinicius.ferneda.tcc.certics.domain.ResultadoEsperado;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;

@ViewController
@PreviousView("./areaCompetencia_list.jsf")
public class AreaCompetenciaEditMB extends AbstractEditPageBean<AreaCompetencia, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private AreaCompetenciaBC areaCompetenciaBC;
	private DataModel<ResultadoEsperado> resultadoEsperadoList;

	public List<SelectItem> getVersaoCertics() {
		return areaCompetenciaBC.getEnumVersaoCertics();
	}
	
	public void addResultadoEsperado() {
		this.getBean().getResultadosEsperados().add(new ResultadoEsperado());
	}
	
	public void deleteResultadoEsperado() {
	   this.getBean().getResultadosEsperados().remove(getResultadoEsperadoList().getRowData());
	}
	
	public DataModel<ResultadoEsperado> getResultadoEsperadoList() {
	   if (resultadoEsperadoList == null) {
		   resultadoEsperadoList = new ListDataModel<ResultadoEsperado>(this.getBean().getResultadosEsperados());
	   }
	   return resultadoEsperadoList;
	} 
	
	@Override
	@Transactional
	public String delete() {
		this.areaCompetenciaBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		this.areaCompetenciaBC.insert(this.getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.areaCompetenciaBC.update(this.getBean());
		return getPreviousView();
	}
	
	@Override
	protected AreaCompetencia handleLoad(Long id) {
		return this.areaCompetenciaBC.load(id);
	}	
}