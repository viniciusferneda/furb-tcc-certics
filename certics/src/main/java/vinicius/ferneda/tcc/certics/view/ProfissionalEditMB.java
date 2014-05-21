package vinicius.ferneda.tcc.certics.view;

import java.util.List;

import javax.faces.model.SelectItem;
import javax.inject.Inject;

import vinicius.ferneda.tcc.certics.business.EnderecoBC;
import vinicius.ferneda.tcc.certics.business.OrganizacaoSolicitanteBC;
import vinicius.ferneda.tcc.certics.business.ProfissionalBC;
import vinicius.ferneda.tcc.certics.business.UsuarioBC;
import vinicius.ferneda.tcc.certics.domain.EnderecoEntity;
import vinicius.ferneda.tcc.certics.domain.OrganizacaoSolicitanteEntity;
import vinicius.ferneda.tcc.certics.domain.ProfissionalEntity;
import vinicius.ferneda.tcc.certics.domain.UsuarioEntity;
import vinicius.ferneda.tcc.certics.util.CriptografiaUtil;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.util.ResourceBundle;

@ViewController
@PreviousView("./profissional_list.jsf")
public class ProfissionalEditMB extends AbstractEditPageBean<ProfissionalEntity, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private ProfissionalBC profissionalBC;
	@Inject
	private OrganizacaoSolicitanteBC organizacaoSolicitanteBC;
	@Inject
	private EnderecoBC enderecoBC;
	@Inject
	private UsuarioBC usuarioBC;
	
	@Inject
	private MessageContext messageContext;
	@Inject
	private ResourceBundle bundle;
	
	private String senhaAtual;
	private String novaSenha;
	
	public List<SelectItem> getUf() {
		return profissionalBC.getEnumUF();
	}
	
	public List<SelectItem> getSexo() {
		return profissionalBC.getEnumSexo();
	}
	
	public List<OrganizacaoSolicitanteEntity> getOrganizacaoSolicitanteList(){
		return organizacaoSolicitanteBC.findAll();
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
		//grava Endereco
		this.enderecoBC.insert(this.getBean().getEndereco());
				
		//grava Usuario
		this.getBean().getUsuario().setSenha(CriptografiaUtil.getCodigoMd5(getNovaSenha()));
		this.usuarioBC.insert(this.getBean().getUsuario());
				
		//grava profissional
		this.profissionalBC.insert(this.getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		UsuarioEntity usuario = this.getBean().getUsuario();
		if(usuario.getSenha().equals(CriptografiaUtil.getCodigoMd5(getSenhaAtual()))){
			usuario.setSenha(CriptografiaUtil.getCodigoMd5(getNovaSenha()));
			this.profissionalBC.update(this.getBean());
		}else{
			messageContext.add(bundle.getString("label.senha.invalida"));
		}
		return getPreviousView();
	}
	
	@Override
	protected ProfissionalEntity handleLoad(Long id) {
		return this.profissionalBC.load(id);
	}	
	
	@Override
	protected ProfissionalEntity createBean() {
		ProfissionalEntity profissional = super.createBean();
		profissional.setEndereco(new EnderecoEntity());
		profissional.setUsuario(new UsuarioEntity());
		return profissional;
	}

	public String getSenhaAtual() {
		return senhaAtual;
	}

	public void setSenhaAtual(String senhaAtual) {
		this.senhaAtual = senhaAtual;
	}

	public String getNovaSenha() {
		return novaSenha;
	}

	public void setNovaSenha(String novaSenha) {
		this.novaSenha = novaSenha;
	}
	
}