
package vinicius.ferneda.tcc.certics.view;

import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;

import vinicius.ferneda.tcc.certics.business.AvaliacaoBC;
import vinicius.ferneda.tcc.certics.business.RespostaEvidenciaBC;
import vinicius.ferneda.tcc.certics.domain.AreaCompetenciaEntity;
import vinicius.ferneda.tcc.certics.domain.AvaliacaoEntity;
import vinicius.ferneda.tcc.certics.domain.ConjuntoEvidenciasEntity;
import vinicius.ferneda.tcc.certics.domain.RespostaEvidenciaEntity;
import vinicius.ferneda.tcc.certics.persistence.AreaCompetenciaDAO;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;

@ViewController
@PreviousView("./conjuntoEvidencias_list.jsf")
public class ConjuntoEvidenciasEditMB extends AbstractEditPageBean<AvaliacaoEntity, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private AvaliacaoBC avaliacaoBC;

	@Inject
	private AreaCompetenciaDAO areaCompetenciaDAO;
	
	private DataModel<AreaCompetenciaEntity> lEvidencias;
	
	public DataModel<AreaCompetenciaEntity> getlEvidencias(){
		if(this.lEvidencias == null){
			this.lEvidencias = new ListDataModel<AreaCompetenciaEntity>(areaCompetenciaDAO.findByVersaoCerticsAndAvaliacaoID(this.getId(), this.getBean().getVersaoCertics()));
		}
		return this.lEvidencias;
	}
	
	@Override
	@Transactional
	public String delete() {
		this.avaliacaoBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		this.avaliacaoBC.insert(this.getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.avaliacaoBC.update(this.getBean());
		return getPreviousView();
	}
	
	@Override
	protected AvaliacaoEntity handleLoad(Long id) {
		return this.avaliacaoBC.load(id);
	}
	
	/*public void addEvidencia(ConjuntoEvidenciasEntity conjuntoEvidenciasEntity){
		Map<String,Object> options = new HashMap<String, Object>();  
        options.put("modal", true);  
        options.put("draggable", false);  
        options.put("resizable", true);  
        options.put("contentHeight", 320);
		RequestContext.getCurrentInstance().openDialog("respostaEvidencia_edit", options, null);
	}*/
	
	private ConjuntoEvidenciasEntity conjuntoEvidenciasEntity;
	
	public void setConjuntoEvidencias(ConjuntoEvidenciasEntity conjuntoEvidenciasEntity){
		this.conjuntoEvidenciasEntity = conjuntoEvidenciasEntity;
	}

	@Inject
	private RespostaEvidenciaBC respostaEvidenciaBC;
	
	private RespostaEvidenciaEntity respostaEvidenciaEntity;

	public void addEvidencia(){
		this.respostaEvidenciaEntity.setConjuntoEvidencias(this.conjuntoEvidenciasEntity);
		this.respostaEvidenciaBC.insert(this.respostaEvidenciaEntity);
	}
	
	public RespostaEvidenciaEntity getRespostaEvidenciaEntity(){
		return this.respostaEvidenciaEntity;
	}

}