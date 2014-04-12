package vinicius.ferneda.tcc.certics.view;

import java.util.List;

import javax.faces.model.SelectItem;
import javax.inject.Inject;

import vinicius.ferneda.tcc.certics.business.AvaliadorBC;
import vinicius.ferneda.tcc.certics.business.EnderecoBC;
import vinicius.ferneda.tcc.certics.business.UsuarioBC;
import vinicius.ferneda.tcc.certics.domain.AvaliadorEntity;
import vinicius.ferneda.tcc.certics.domain.EnderecoEntity;
import vinicius.ferneda.tcc.certics.domain.UsuarioEntity;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;

@ViewController
@PreviousView("./usuario_list.jsf")
public class UsuarioEditMB extends AbstractEditPageBean<UsuarioEntity, Long> {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private UsuarioBC usuarioBC;
	
	@Inject
	private AvaliadorBC avaliadorBC;
	
	@Inject
	private EnderecoBC enderecoBC;
	
	public List<SelectItem> getSexo() {
		return usuarioBC.getEnumSexo();
	}
	
	public List<SelectItem> getUf() {
		return usuarioBC.getEnumUF();
	}
	
	@Override
	@Transactional
	public String delete() {
		this.usuarioBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		//grava Endereco
		this.enderecoBC.insert(this.getBean().getAvaliador().getEndereco());
		
		//grava Avaliador
		this.avaliadorBC.insert(this.getBean().getAvaliador());
		
		//grava Usuario
		this.usuarioBC.insert(this.getBean());
		
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.usuarioBC.update(this.getBean());
		return getPreviousView();
	}
	
	@Override
	protected UsuarioEntity handleLoad(Long id) {
		return this.usuarioBC.load(id);
	}
	
	@Override
	protected UsuarioEntity createBean() {
		UsuarioEntity usuario = super.createBean();
		usuario.setAvaliador(new AvaliadorEntity());
		usuario.getAvaliador().setEndereco(new EnderecoEntity());
		return usuario;
	}
	
}