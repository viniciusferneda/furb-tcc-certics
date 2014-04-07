
package vinicius.ferneda.tcc.certics.view;

import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;

import vinicius.ferneda.tcc.certics.business.SoftwareBC;
import vinicius.ferneda.tcc.certics.domain.Avaliacao;
import vinicius.ferneda.tcc.certics.domain.Software;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;

@ViewController
@PreviousView("./software_list.jsf")
public class SoftwareEditMB extends AbstractEditPageBean<Software, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private SoftwareBC softwareBC;
	

	private DataModel<Avaliacao> avaliacaoList;
	
	public void addAvaliacao() {
		this.getBean().getAvaliacoes().add(new Avaliacao());
	}
	public void deleteAvaliacao() {
	   this.getBean().getAvaliacoes().remove(getAvaliacaoList().getRowData());
	}
	public DataModel<Avaliacao> getAvaliacaoList() {
	   if (avaliacaoList == null) {
		   avaliacaoList = new ListDataModel<Avaliacao>(this.getBean().getAvaliacoes());
	   }
	   return avaliacaoList;
	} 
	
	@Override
	@Transactional
	public String delete() {
		this.softwareBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		this.softwareBC.insert(this.getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.softwareBC.update(this.getBean());
		return getPreviousView();
	}
	
	@Override
	protected Software handleLoad(Long id) {
		return this.softwareBC.load(id);
	}	
}