
package vinicius.ferneda.tcc.certics.view;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.primefaces.model.DualListModel;

import vinicius.ferneda.tcc.certics.business.AreaCompetenciaBC;
import vinicius.ferneda.tcc.certics.business.ResultadoEsperadoBC;
import vinicius.ferneda.tcc.certics.business.VersaoCerticsEntityBC;
import vinicius.ferneda.tcc.certics.domain.AreaCompetenciaEntity;
import vinicius.ferneda.tcc.certics.domain.ResultadoEsperadoEntity;
import vinicius.ferneda.tcc.certics.domain.VersaoCerticsEntity;
import vinicius.ferneda.tcc.certics.domain.VersaoCerticsResultadoEsperadoEntity;
import vinicius.ferneda.tcc.certics.persistence.VersaoCerticsResultadoEsperadoEntityDAO;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;

@ViewController
@PreviousView("./resultadoEsperado_list.jsf")
public class ResultadoEsperadoEditMB extends AbstractEditPageBean<ResultadoEsperadoEntity, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private ResultadoEsperadoBC resultadoEsperadoBC;

	@Inject
	private VersaoCerticsResultadoEsperadoEntityDAO versaoCerticsResultadoEsperadoEntityDAO;
	
	@Inject
	private VersaoCerticsEntityBC versaoCerticsEntityBC;
	private DualListModel<VersaoCerticsEntity> lVersaoCertics;
	
	@Inject
	private AreaCompetenciaBC areaCompetenciaBC;
	
	public List<AreaCompetenciaEntity> getAreaCompetenciaList(){
		return areaCompetenciaBC.findAll();
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
		//Registra as versoes vinculadas
		if(getlVersaoCertics().getTarget() != null && !getlVersaoCertics().getTarget().isEmpty()){
			for (VersaoCerticsEntity versaoCerticsEntity : getlVersaoCertics().getTarget()) {
				this.versaoCerticsResultadoEsperadoEntityDAO.insert(new VersaoCerticsResultadoEsperadoEntity(this.getBean(), versaoCerticsEntity));
			}
		}
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.resultadoEsperadoBC.update(this.getBean());
		
		//Registra as versoes vinculadas
		incluirVersaoCertics();
		
		//Exclui as versões que não estão mais vinculadas
		excluirVersaoCertics();
		
		return getPreviousView();
	}

	private void incluirVersaoCertics() {
		if(getlVersaoCertics().getTarget() != null && !getlVersaoCertics().getTarget().isEmpty()){
			for (VersaoCerticsEntity versaoCerticsEntity : getlVersaoCertics().getTarget()) {
				if(!this.versaoCerticsResultadoEsperadoEntityDAO.possuiVersaoCertics(versaoCerticsEntity.getId(), getId())){
					this.versaoCerticsResultadoEsperadoEntityDAO.insert(new VersaoCerticsResultadoEsperadoEntity(this.getBean(), versaoCerticsEntity));
				}
			}
		}
	}
	
	private void excluirVersaoCertics(){
		if(getlVersaoCertics().getSource() != null && !getlVersaoCertics().getSource().isEmpty()){
			for (VersaoCerticsEntity versaoCerticsEntity : getlVersaoCertics().getSource()) {
				VersaoCerticsResultadoEsperadoEntity versaoCerticsResultadoEsperadoEntity = this.versaoCerticsResultadoEsperadoEntityDAO.findByVersaoCerticsID(versaoCerticsEntity.getId(), getId());
				if(versaoCerticsResultadoEsperadoEntity != null){
					this.versaoCerticsResultadoEsperadoEntityDAO.delete(versaoCerticsResultadoEsperadoEntity.getId());
				}
			}
		}
	}
	
	@Override
	protected ResultadoEsperadoEntity handleLoad(Long id) {
		ResultadoEsperadoEntity resultadoEsperadoEntity = this.resultadoEsperadoBC.load(id);
		//cria a lista de versões
		montaListaVersoes(resultadoEsperadoEntity);
		return resultadoEsperadoEntity; 
	}
	
	private void montaListaVersoes(ResultadoEsperadoEntity resultadoEsperadoEntity) {
		//recupera as versoes vinculadas
		List<VersaoCerticsResultadoEsperadoEntity> lVersaoCerticsAreaCompetencia = resultadoEsperadoEntity.getlVersaoCerticsResultadoEsperado();
		List<VersaoCerticsEntity> lVersaoCerticsTarget = new ArrayList<VersaoCerticsEntity>();
		for (VersaoCerticsResultadoEsperadoEntity versao : lVersaoCerticsAreaCompetencia) {
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
	protected ResultadoEsperadoEntity createBean() {
		ResultadoEsperadoEntity resultadoEsperado = super.createBean();
		this.lVersaoCertics = new DualListModel<VersaoCerticsEntity>(this.versaoCerticsEntityBC.findAll(), new ArrayList<VersaoCerticsEntity>());
		return resultadoEsperado;
	}
	
	public DualListModel<VersaoCerticsEntity> getlVersaoCertics() {
		return lVersaoCertics;
	}

	public void setlVersaoCertics(DualListModel<VersaoCerticsEntity> lVersaoCertics) {
		this.lVersaoCertics = lVersaoCertics;
	}
	
}