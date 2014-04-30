
package vinicius.ferneda.tcc.certics.view;

import java.util.List;

import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;

import vinicius.ferneda.tcc.certics.business.EvidenciaBC;
import vinicius.ferneda.tcc.certics.business.RespostaEvidenciaBC;
import vinicius.ferneda.tcc.certics.domain.AnexoEntity;
import vinicius.ferneda.tcc.certics.domain.EvidenciaEntity;
import vinicius.ferneda.tcc.certics.domain.RespostaEvidenciaEntity;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;

@ViewController
@PreviousView("./evidencia_list.jsf")
public class EvidenciaEditMB extends AbstractEditPageBean<EvidenciaEntity, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private EvidenciaBC evidenciaBC;
	

	@Inject
	private RespostaEvidenciaBC respostaEvidenciaBC;
	
	public List<RespostaEvidenciaEntity> getRespostaEvidenciaList(){
		return respostaEvidenciaBC.findAll();
	}
			
	private DataModel<AnexoEntity> anexoList;
	
	public void addAnexo() {
		this.getBean().getAnexos().add(new AnexoEntity());
	}
	public void deleteAnexo() {
	   this.getBean().getAnexos().remove(getAnexoList().getRowData());
	}
	public DataModel<AnexoEntity> getAnexoList() {
	   if (anexoList == null) {
		   anexoList = new ListDataModel<AnexoEntity>(this.getBean().getAnexos());
	   }
	   return anexoList;
	} 
	
	@Override
	@Transactional
	public String delete() {
		this.evidenciaBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		this.evidenciaBC.insert(this.getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.evidenciaBC.update(this.getBean());
		return getPreviousView();
	}
	
	@Override
	protected EvidenciaEntity handleLoad(Long id) {
		return this.evidenciaBC.load(id);
	}	
}