
package vinicius.ferneda.tcc.certics.view;

import java.util.List;

import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.inject.Inject;

import vinicius.ferneda.tcc.certics.business.AreaCompetenciaBC;
import vinicius.ferneda.tcc.certics.business.ResultadoEsperadoBC;
import vinicius.ferneda.tcc.certics.domain.AreaCompetenciaEntity;
import vinicius.ferneda.tcc.certics.domain.ResultadoEsperadoEntity;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;

@ViewController
@PreviousView("./areaCompetencia_list.jsf")
public class AreaCompetenciaEditMB extends AbstractEditPageBean<AreaCompetenciaEntity, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private AreaCompetenciaBC areaCompetenciaBC;
	
	@Inject
	private ResultadoEsperadoBC resultadoEsperadoBC;
	
	private DataModel<ResultadoEsperadoEntity> resultadoEsperadoList;

	public List<SelectItem> getVersaoCertics() {
		return areaCompetenciaBC.getEnumVersaoCertics();
	}
	
	public void addResultadoEsperado() {
		this.getBean().getResultadosEsperados().add(new ResultadoEsperadoEntity());
	}
	
	public void deleteResultadoEsperado() {
	   this.getBean().getResultadosEsperados().remove(getResultadoEsperadoList().getRowData());
	}
	
	public DataModel<ResultadoEsperadoEntity> getResultadoEsperadoList() {
	   if (resultadoEsperadoList == null) {
		   resultadoEsperadoList = new ListDataModel<ResultadoEsperadoEntity>(this.getBean().getResultadosEsperados());
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
		for (ResultadoEsperadoEntity res : this.getBean().getResultadosEsperados()) {
			res.setAreaCompetencia(this.getBean());
			this.resultadoEsperadoBC.insert(res);
		}
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.areaCompetenciaBC.update(this.getBean());
		return getPreviousView();
	}
	
	@Override
	protected AreaCompetenciaEntity handleLoad(Long id) {
		return this.areaCompetenciaBC.load(id);
	}	
}