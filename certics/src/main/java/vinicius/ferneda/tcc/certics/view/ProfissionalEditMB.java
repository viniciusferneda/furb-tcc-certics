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
import vinicius.ferneda.tcc.certics.domain.EnderecoEntity;
import vinicius.ferneda.tcc.certics.domain.EvidenciaProfissionalEntity;
import vinicius.ferneda.tcc.certics.domain.OrganizacaoSolicitanteEntity;
import vinicius.ferneda.tcc.certics.domain.Profissional;
import vinicius.ferneda.tcc.certics.domain.UsuarioEntity;
import vinicius.ferneda.tcc.certics.persistence.EnderecoDAO;
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
	
	@Inject
	private EnderecoDAO enderecoDAO;
	
	public EnderecoEntity getEndereco(){
		if(getId() != null){
			return enderecoDAO.findByOrgnizacaoSolicitanteID(getId());
		}else{
			return new EnderecoEntity();
		}
	}
	
	public List<OrganizacaoSolicitanteEntity> getOrganizacaoSolicitanteList(){
		return organizacaoSolicitanteBC.findAll();
	}
			
	private DataModel<UsuarioEntity> usuarioList;
	
	public void addUsuario() {
		this.getBean().getUsuarios().add(new UsuarioEntity());
	}
	public void deleteUsuario() {
	   this.getBean().getUsuarios().remove(getUsuarioList().getRowData());
	}
	public DataModel<UsuarioEntity> getUsuarioList() {
	   if (usuarioList == null) {
		   usuarioList = new ListDataModel<UsuarioEntity>(this.getBean().getUsuarios());
	   }
	   return usuarioList;
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