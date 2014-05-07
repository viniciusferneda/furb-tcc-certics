package vinicius.ferneda.tcc.certics.view;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;

import org.primefaces.event.FileUploadEvent;

import vinicius.ferneda.tcc.certics.business.EvidenciaEntityBC;
import vinicius.ferneda.tcc.certics.domain.AnexoEntity;
import vinicius.ferneda.tcc.certics.domain.EvidenciaEntity;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;

@ViewController
@PreviousView("./evidenciaEntity_list.jsf")
@SessionScoped
public class EvidenciaEntityEditMB extends AbstractEditPageBean<EvidenciaEntity, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private EvidenciaEntityBC evidenciaEntityBC;
	
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
		this.evidenciaEntityBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		this.evidenciaEntityBC.insert(getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.evidenciaEntityBC.update(getBean());
		return getPreviousView();
	}
	
	@Override
	protected EvidenciaEntity handleLoad(Long id) {
		return this.evidenciaEntityBC.load(id);
	}
	
	public void handleFileUpload(FileUploadEvent event) {
		FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

}