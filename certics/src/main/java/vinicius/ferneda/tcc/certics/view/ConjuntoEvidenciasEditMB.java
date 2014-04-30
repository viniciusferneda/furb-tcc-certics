
package vinicius.ferneda.tcc.certics.view;

import java.util.List;

import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.inject.Inject;

import vinicius.ferneda.tcc.certics.business.AvaliacaoBC;
import vinicius.ferneda.tcc.certics.business.EvidenciaBC;
import vinicius.ferneda.tcc.certics.business.RespostaEvidenciaBC;
import vinicius.ferneda.tcc.certics.domain.AnexoEntity;
import vinicius.ferneda.tcc.certics.domain.AreaCompetenciaEntity;
import vinicius.ferneda.tcc.certics.domain.AvaliacaoEntity;
import vinicius.ferneda.tcc.certics.domain.ConjuntoEvidenciasEntity;
import vinicius.ferneda.tcc.certics.domain.EvidenciaEntity;
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

	@Inject
	private RespostaEvidenciaBC respostaEvidenciaBC;
	private RespostaEvidenciaEntity respostaEvidenciaEntity;

	@Inject
	private EvidenciaBC evidenciaBC;
	private EvidenciaEntity evidenciaEntity;

	private ConjuntoEvidenciasEntity conjuntoEvidenciasEntity;

	private DataModel<AreaCompetenciaEntity> lEvidencias;
	
	public DataModel<AreaCompetenciaEntity> getlEvidencias(){
		if(this.lEvidencias == null){
			this.lEvidencias = new ListDataModel<AreaCompetenciaEntity>(areaCompetenciaDAO.findByVersaoCerticsAndAvaliacaoID(this.getId(), this.getBean().getVersaoCertics()));
		}
		return this.lEvidencias;
	}
	
	public List<SelectItem> getEvidenciaList(){
		return this.evidenciaBC.getEvidenciaList();
	}
	
	private DataModel<AnexoEntity> anexoList;

	public void addAnexo() {
		this.getEvidenciaEntity().getAnexos().add(new AnexoEntity());
	}
	public void deleteAnexo() {
	   this.getEvidenciaEntity().getAnexos().remove(getAnexoList().getRowData());
	}
	public DataModel<AnexoEntity> getAnexoList() {
	   if (anexoList == null) {
		   if(evidenciaEntity == null){
			   anexoList = new ListDataModel<AnexoEntity>();
		   }else{
			   anexoList = new ListDataModel<AnexoEntity>(this.getEvidenciaEntity().getAnexos());
		   }
	   }
	   return anexoList;
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
	
	public void setConjuntoEvidencias(ConjuntoEvidenciasEntity conjuntoEvidenciasEntity){
		this.conjuntoEvidenciasEntity = conjuntoEvidenciasEntity;
		this.respostaEvidenciaEntity = new RespostaEvidenciaEntity();
	}
	
	public void setEvidencia(){
		this.evidenciaEntity = new EvidenciaEntity();
	}

	public void addRespostaEvidencia(){
		this.respostaEvidenciaEntity.setConjuntoEvidencias(this.conjuntoEvidenciasEntity);
		this.respostaEvidenciaBC.insert(this.respostaEvidenciaEntity);
	}

	public void addEvidencia(){
		this.evidenciaBC.insert(this.evidenciaEntity);
	}

	public RespostaEvidenciaEntity getRespostaEvidenciaEntity(){
		return this.respostaEvidenciaEntity;
	}
	
	public EvidenciaEntity getEvidenciaEntity(){
		return this.evidenciaEntity;
	}

}