
package vinicius.ferneda.tcc.certics.view;

import java.util.List;

import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.inject.Inject;

import vinicius.ferneda.tcc.certics.business.AvaliacaoBC;
import vinicius.ferneda.tcc.certics.business.ConjuntoEvidenciasBC;
import vinicius.ferneda.tcc.certics.business.RespostaEvidenciaBC;
import vinicius.ferneda.tcc.certics.domain.Avaliacao;
import vinicius.ferneda.tcc.certics.domain.ConjuntoEvidencias;
import vinicius.ferneda.tcc.certics.domain.EvidenciaEntity;
import vinicius.ferneda.tcc.certics.domain.EvidenciaProfissionalEntity;
import vinicius.ferneda.tcc.certics.domain.RespostaEvidencia;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;

@ViewController
@PreviousView("./respostaEvidencia_list.jsf")
public class RespostaEvidenciaEditMB extends AbstractEditPageBean<RespostaEvidencia, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private RespostaEvidenciaBC respostaEvidenciaBC;
	

	public List<SelectItem> getPontuacao() {
		return respostaEvidenciaBC.getEnumPontuacaoEvidencia();
	}
	@Inject
	private AvaliacaoBC avaliacaoBC;
	
	public List<Avaliacao> getAvaliacaoList(){
		return avaliacaoBC.findAll();
	}
			
	@Inject
	private ConjuntoEvidenciasBC conjuntoEvidenciasBC;
	
	public List<ConjuntoEvidencias> getConjuntoEvidenciasList(){
		return conjuntoEvidenciasBC.findAll();
	}
			
	private DataModel<EvidenciaProfissionalEntity> evidenciaProfissionalList;
	
	public void addEvidenciaProfissional() {
		this.getBean().getProfissionais().add(new EvidenciaProfissionalEntity());
	}
	public void deleteEvidenciaProfissional() {
	   this.getBean().getProfissionais().remove(getEvidenciaProfissionalList().getRowData());
	}
	public DataModel<EvidenciaProfissionalEntity> getEvidenciaProfissionalList() {
	   if (evidenciaProfissionalList == null) {
		   evidenciaProfissionalList = new ListDataModel<EvidenciaProfissionalEntity>(this.getBean().getProfissionais());
	   }
	   return evidenciaProfissionalList;
	} 
	private DataModel<EvidenciaEntity> evidenciaList;
	
	public void addEvidencia() {
		this.getBean().getEvidencias().add(new EvidenciaEntity());
	}
	public void deleteEvidencia() {
	   this.getBean().getEvidencias().remove(getEvidenciaList().getRowData());
	}
	public DataModel<EvidenciaEntity> getEvidenciaList() {
	   if (evidenciaList == null) {
		   evidenciaList = new ListDataModel<EvidenciaEntity>(this.getBean().getEvidencias());
	   }
	   return evidenciaList;
	} 
	
	@Override
	@Transactional
	public String delete() {
		this.respostaEvidenciaBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		this.respostaEvidenciaBC.insert(this.getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.respostaEvidenciaBC.update(this.getBean());
		return getPreviousView();
	}
	
	@Override
	protected RespostaEvidencia handleLoad(Long id) {
		return this.respostaEvidenciaBC.load(id);
	}	
}