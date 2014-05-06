
package vinicius.ferneda.tcc.certics.view;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;

import org.primefaces.model.DualListModel;

import vinicius.ferneda.tcc.certics.business.AreaCompetenciaBC;
import vinicius.ferneda.tcc.certics.business.ResultadoEsperadoBC;
import vinicius.ferneda.tcc.certics.business.VersaoCerticsEntityBC;
import vinicius.ferneda.tcc.certics.domain.AreaCompetenciaEntity;
import vinicius.ferneda.tcc.certics.domain.ResultadoEsperadoEntity;
import vinicius.ferneda.tcc.certics.domain.VersaoCerticsAreaCompetenciaEntity;
import vinicius.ferneda.tcc.certics.domain.VersaoCerticsEntity;
import vinicius.ferneda.tcc.certics.persistence.VersaoCerticsAreaCompetenciaEntityDAO;
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
	private VersaoCerticsAreaCompetenciaEntityDAO versaoCerticsAreaCompetenciaEntityDAO;
	
	@Inject
	private VersaoCerticsEntityBC versaoCerticsEntityBC;
	private DualListModel<VersaoCerticsEntity> lVersaoCertics;
	
	@Inject
	private ResultadoEsperadoBC resultadoEsperadoBC;
	
	private DataModel<ResultadoEsperadoEntity> resultadoEsperadoList;

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
		//Registra as versoes vinculadas
		if(getlVersaoCertics().getTarget() != null && !getlVersaoCertics().getTarget().isEmpty()){
			for (VersaoCerticsEntity versaoCerticsEntity : getlVersaoCertics().getTarget()) {
				this.versaoCerticsAreaCompetenciaEntityDAO.insert(new VersaoCerticsAreaCompetenciaEntity(this.getBean(), versaoCerticsEntity));
			}
		}
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.areaCompetenciaBC.update(this.getBean());
		//Registra as versoes vinculadas
		if(getlVersaoCertics().getTarget() != null && !getlVersaoCertics().getTarget().isEmpty()){
			for (VersaoCerticsEntity versaoCerticsEntity : getlVersaoCertics().getTarget()) {
				this.versaoCerticsAreaCompetenciaEntityDAO.insert(new VersaoCerticsAreaCompetenciaEntity(this.getBean(), versaoCerticsEntity));
			}
		}
		return getPreviousView();
	}
	
	@Override
	protected AreaCompetenciaEntity handleLoad(Long id) {
		AreaCompetenciaEntity areaCompetenciaEntity = this.areaCompetenciaBC.load(id);
		//cria a lista de versões
		montaListaVersoes(areaCompetenciaEntity);
		return areaCompetenciaEntity;
	}

	private void montaListaVersoes(AreaCompetenciaEntity areaCompetenciaEntity) {
		//recupera as versoes vinculadas
		List<VersaoCerticsAreaCompetenciaEntity> lVersaoCerticsAreaCompetencia = areaCompetenciaEntity.getlVersaoCerticsAreaCompetencia();
		List<VersaoCerticsEntity> lVersaoCerticsTarget = new ArrayList<VersaoCerticsEntity>();
		for (VersaoCerticsAreaCompetenciaEntity versao : lVersaoCerticsAreaCompetencia) {
			lVersaoCerticsTarget.add(versao.getVersaoCertics());
		}
		
		//remove as repetidas
		List<VersaoCerticsEntity> lVersaoCerticsSource = this.versaoCerticsEntityBC.findAll();
		List<VersaoCerticsEntity> lVersaoCerticsSourceRemove = new ArrayList<VersaoCerticsEntity>();
		for (VersaoCerticsEntity versaoCerticsEntitySource : lVersaoCerticsSource) {
			for (VersaoCerticsEntity versaoCerticsEntityTarget : lVersaoCerticsTarget) {
				if(versaoCerticsEntitySource.getId().equals(versaoCerticsEntityTarget.getId())){
					lVersaoCerticsSourceRemove.add(versaoCerticsEntitySource);
				}
			}
		}
		lVersaoCerticsSource.removeAll(lVersaoCerticsSourceRemove);
		
		//monta a lista
		this.lVersaoCertics = new DualListModel<VersaoCerticsEntity>(lVersaoCerticsSource, lVersaoCerticsTarget);
	}
	
	@Override
	protected AreaCompetenciaEntity createBean() {
		AreaCompetenciaEntity areaCompetenciaEntity = super.createBean();
		this.lVersaoCertics = new DualListModel<VersaoCerticsEntity>(this.versaoCerticsEntityBC.findAll(), new ArrayList<VersaoCerticsEntity>());
		return areaCompetenciaEntity;
	}

	public DualListModel<VersaoCerticsEntity> getlVersaoCertics() {
		return lVersaoCertics;
	}

	public void setlVersaoCertics(DualListModel<VersaoCerticsEntity> lVersaoCertics) {
		this.lVersaoCertics = lVersaoCertics;
	}
	
}