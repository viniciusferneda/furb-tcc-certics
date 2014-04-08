
package vinicius.ferneda.tcc.certics.view;

import java.util.List;

import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;

import vinicius.ferneda.tcc.certics.business.EnderecoBC;
import vinicius.ferneda.tcc.certics.business.OrganizacaoSolicitanteBC;
import vinicius.ferneda.tcc.certics.domain.Endereco;
import vinicius.ferneda.tcc.certics.domain.OrganizacaoSolicitante;
import vinicius.ferneda.tcc.certics.domain.Profissional;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;

@ViewController
@PreviousView("./organizacaoSolicitante_list.jsf")
public class OrganizacaoSolicitanteEditMB extends AbstractEditPageBean<OrganizacaoSolicitante, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private OrganizacaoSolicitanteBC organizacaoSolicitanteBC;
	

	@Inject
	private EnderecoBC enderecoBC;
	
	public List<Endereco> getEnderecoList(){
		return enderecoBC.findAll();
	}
			
	private DataModel<Profissional> profissionalList;
	
	public void addProfissional() {
		this.getBean().getProfissionais().add(new Profissional());
	}
	public void deleteProfissional() {
	   this.getBean().getProfissionais().remove(getProfissionalList().getRowData());
	}
	public DataModel<Profissional> getProfissionalList() {
	   if (profissionalList == null) {
		   profissionalList = new ListDataModel<Profissional>(this.getBean().getProfissionais());
	   }
	   return profissionalList;
	} 
	
	@Override
	@Transactional
	public String delete() {
		this.organizacaoSolicitanteBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		this.organizacaoSolicitanteBC.insert(this.getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.organizacaoSolicitanteBC.update(this.getBean());
		return getPreviousView();
	}
	
	@Override
	protected OrganizacaoSolicitante handleLoad(Long id) {
		return this.organizacaoSolicitanteBC.load(id);
	}	
}