
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

	@Inject
	private EvidenciaBC evidenciaBC;

	private DataModel<AreaCompetenciaEntity> lEvidencias;
	
	public DataModel<AreaCompetenciaEntity> getlEvidencias(){
		if(this.lEvidencias == null){
			this.lEvidencias = new ListDataModel<AreaCompetenciaEntity>(areaCompetenciaDAO.findByVersaoCerticsAndAvaliacaoID(this.getId(), this.getBean().getVersaoCertics().getId()));
		}
		return this.lEvidencias;
	}
	
	public List<SelectItem> getEvidenciaList(){
		return this.evidenciaBC.getEvidenciaList();
	}
	
	private DataModel<AnexoEntity> anexoList;

	public void addAnexo() {
		this.getEvidenciaAux().getAnexos().add(new AnexoEntity());
	}
	public void deleteAnexo() {
	   this.getEvidenciaAux().getAnexos().remove(getAnexoList().getRowData());
	}
	public DataModel<AnexoEntity> getAnexoList() {
	   if (anexoList == null) {
		   if(this.getEvidenciaAux() == null){
			   anexoList = new ListDataModel<AnexoEntity>();
		   }else{
			   anexoList = new ListDataModel<AnexoEntity>(this.getEvidenciaAux().getAnexos());
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
		this.setConjuntoEvidenciasAux(conjuntoEvidenciasEntity);
		this.setRespostaEvidenciaAux(new RespostaEvidenciaEntity());
	}
	
	public void setNovaEvidencia(){
		this.setEvidenciaAux(new EvidenciaEntity());
	}

	public void addRespostaEvidencia(){
		this.getRespostaEvidenciaAux().setConjuntoEvidencias(this.getConjuntoEvidenciasAux());
		this.respostaEvidenciaBC.insert(this.getRespostaEvidenciaAux());
	}

	public void setEvidencia(){
		String evidenciaNome = this.getEvidenciaNome();
		String evidenciaDescricao = this.getEvidenciaDescricao();
		this.evidenciaBC.insert(new EvidenciaEntity(evidenciaNome, evidenciaDescricao));
	}

	private ConjuntoEvidenciasEntity conjuntoEvidenciasAux;
	private RespostaEvidenciaEntity respostaEvidenciaAux;
	private EvidenciaEntity evidenciaAux;
	private String evidenciaNome;
	private String evidenciaDescricao;
	
	public String getEvidenciaNome() {
		return evidenciaNome;
	}

	public void setEvidenciaNome(String evidenciaNome) {
		this.evidenciaNome = evidenciaNome;
	}

	public String getEvidenciaDescricao() {
		return evidenciaDescricao;
	}

	public void setEvidenciaDescricao(String evidenciaDescricao) {
		this.evidenciaDescricao = evidenciaDescricao;
	}

	public ConjuntoEvidenciasEntity getConjuntoEvidenciasAux() {
		return conjuntoEvidenciasAux;
	}

	public void setConjuntoEvidenciasAux(ConjuntoEvidenciasEntity conjuntoEvidenciasAux) {
		this.conjuntoEvidenciasAux = conjuntoEvidenciasAux;
	}

	public RespostaEvidenciaEntity getRespostaEvidenciaAux() {
		return respostaEvidenciaAux;
	}

	public void setRespostaEvidenciaAux(RespostaEvidenciaEntity respostaEvidenciaAux) {
		this.respostaEvidenciaAux = respostaEvidenciaAux;
	}

	public EvidenciaEntity getEvidenciaAux() {
		return evidenciaAux;
	}

	public void setEvidenciaAux(EvidenciaEntity evidenciaAux) {
		this.evidenciaAux = evidenciaAux;
	}
	
}