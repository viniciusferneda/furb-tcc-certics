package vinicius.ferneda.tcc.certics.view;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import vinicius.ferneda.tcc.certics.business.AnexoBC;
import vinicius.ferneda.tcc.certics.business.EvidenciaEntityBC;
import vinicius.ferneda.tcc.certics.domain.AnexoEntity;
import vinicius.ferneda.tcc.certics.domain.EvidenciaEntity;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;

@ViewController
@PreviousView("./evidenciaEntity_list.jsf")
public class EvidenciaEntityEditMB extends AbstractEditPageBean<EvidenciaEntity, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private EvidenciaEntityBC evidenciaEntityBC;
	
	@Inject
	private AnexoBC anexoBC;
	
	private List<AnexoEntity> lAnexosAux = new ArrayList<AnexoEntity>();
	
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
		retiraAnexos(getBean().getAnexos());
		this.evidenciaEntityBC.insert(getBean());
		for (AnexoEntity anexo : getlAnexosAux()) {
			this.anexoBC.insert(anexo);
		}
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		retiraAnexos(getBean().getAnexos());
		for (AnexoEntity anexo : getlAnexosAux()) {
			if(anexo.getId() != null){
				this.anexoBC.update(anexo);
			}else{
				this.anexoBC.insert(anexo);
			}
		}
		this.evidenciaEntityBC.update(getBean());
		return getPreviousView();
	}
	
	@Override
	protected EvidenciaEntity handleLoad(Long id) {
		return this.evidenciaEntityBC.load(id);
	}
	
	public void handleFileUpload(FileUploadEvent event) {
		UploadedFile uploadedFile = event.getFile();
		AnexoEntity anexoAux = (AnexoEntity) event.getComponent().getAttributes().get("anexoAux");
		boolean existeAnexo = false;
		for (AnexoEntity anexo : this.anexoList) {
			if(anexoAux.getId() != null && anexoAux.getId().equals(anexo.getId())){
				anexo.setNome(uploadedFile.getFileName());
				anexo.setArquivo(uploadedFile.getContents());
				existeAnexo = true;
				break;
			}
		}
		if(!existeAnexo){
			this.getBean().getAnexos().add(new AnexoEntity(uploadedFile.getFileName(),uploadedFile.getContents(),getBean()));
		}
	}
	
	private void retiraAnexos(List<AnexoEntity> lAnexos){
		if(lAnexos != null && !lAnexos.isEmpty()){
			List<AnexoEntity> lAnexosRemove = new ArrayList<AnexoEntity>();
			for (AnexoEntity anexo : lAnexos) {
				if(anexo.getArquivo() == null){
					lAnexosRemove.add(anexo);
				}else{
					this.getlAnexosAux().add(anexo);
				}
			}
			lAnexos.removeAll(lAnexosRemove);
		}
	}
	
	public List<AnexoEntity> getlAnexosAux() {
		return lAnexosAux;
	}
	public void setlAnexosAux(List<AnexoEntity> lAnexosAux) {
		this.lAnexosAux = lAnexosAux;
	}
	
}