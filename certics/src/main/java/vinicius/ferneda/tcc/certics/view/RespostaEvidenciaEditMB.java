
package vinicius.ferneda.tcc.certics.view;

import java.util.List;

import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.inject.Inject;

import vinicius.ferneda.tcc.certics.business.AvaliacaoBC;
import vinicius.ferneda.tcc.certics.business.ConjuntoEvidenciasBC;
import vinicius.ferneda.tcc.certics.business.RespostaEvidenciaBC;
import vinicius.ferneda.tcc.certics.domain.AvaliacaoEntity;
import vinicius.ferneda.tcc.certics.domain.ConjuntoEvidenciasEntity;
import vinicius.ferneda.tcc.certics.domain.EvidenciaProfissionalEntity;
import vinicius.ferneda.tcc.certics.domain.RespostaEvidenciaEntity;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;

@ViewController
@PreviousView("./respostaEvidencia_list.jsf")
public class RespostaEvidenciaEditMB extends AbstractEditPageBean<RespostaEvidenciaEntity, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private RespostaEvidenciaBC respostaEvidenciaBC;
	

	public List<SelectItem> getPontuacao() {
		return respostaEvidenciaBC.getEnumPontuacaoEvidencia();
	}
	@Inject
	private AvaliacaoBC avaliacaoBC;
	
	public List<AvaliacaoEntity> getAvaliacaoList(){
		return avaliacaoBC.findAll();
	}
			
	@Inject
	private ConjuntoEvidenciasBC conjuntoEvidenciasBC;
	
	public List<ConjuntoEvidenciasEntity> getConjuntoEvidenciasList(){
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
	protected RespostaEvidenciaEntity handleLoad(Long id) {
		return this.respostaEvidenciaBC.load(id);
	}	
}