
package vinicius.ferneda.tcc.certics.view;

import java.util.List;

import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.inject.Inject;

import vinicius.ferneda.tcc.certics.business.EnderecoBC;
import vinicius.ferneda.tcc.certics.business.OrganizacaoSolicitanteBC;
import vinicius.ferneda.tcc.certics.business.ProfissionalBC;
import vinicius.ferneda.tcc.certics.domain.Endereco;
import vinicius.ferneda.tcc.certics.domain.EvidenciaProfissional;
import vinicius.ferneda.tcc.certics.domain.OrganizacaoSolicitante;
import vinicius.ferneda.tcc.certics.domain.Profissional;
import vinicius.ferneda.tcc.certics.domain.Usuario;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;

@ViewController
@PreviousView("./profissional_list.jsf")
public class ProfissionalEditMB extends AbstractEditPageBean<Profissional, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private ProfissionalBC profissionalBC;
	

	@Inject
	private OrganizacaoSolicitanteBC organizacaoSolicitanteBC;
	
	public List<OrganizacaoSolicitante> getOrganizacaoSolicitanteList(){
		return organizacaoSolicitanteBC.findAll();
	}
			
	private DataModel<Usuario> usuarioList;
	
	public void addUsuario() {
		this.getBean().getUsuarios().add(new Usuario());
	}
	public void deleteUsuario() {
	   this.getBean().getUsuarios().remove(getUsuarioList().getRowData());
	}
	public DataModel<Usuario> getUsuarioList() {
	   if (usuarioList == null) {
		   usuarioList = new ListDataModel<Usuario>(this.getBean().getUsuarios());
	   }
	   return usuarioList;
	} 
	private DataModel<EvidenciaProfissional> evidenciaProfissionalList;
	
	public void addEvidenciaProfissional() {
		this.getBean().getProfissionais().add(new EvidenciaProfissional());
	}
	public void deleteEvidenciaProfissional() {
	   this.getBean().getProfissionais().remove(getEvidenciaProfissionalList().getRowData());
	}
	public DataModel<EvidenciaProfissional> getEvidenciaProfissionalList() {
	   if (evidenciaProfissionalList == null) {
		   evidenciaProfissionalList = new ListDataModel<EvidenciaProfissional>(this.getBean().getProfissionais());
	   }
	   return evidenciaProfissionalList;
	} 
	public List<SelectItem> getSexo() {
		return profissionalBC.getEnumSexo();
	}
	@Inject
	private EnderecoBC enderecoBC;
	
	public List<Endereco> getEnderecoList(){
		return enderecoBC.findAll();
	}
			
	
	@Override
	@Transactional
	public String delete() {
		this.profissionalBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		this.profissionalBC.insert(this.getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.profissionalBC.update(this.getBean());
		return getPreviousView();
	}
	
	@Override
	protected Profissional handleLoad(Long id) {
		return this.profissionalBC.load(id);
	}	
}