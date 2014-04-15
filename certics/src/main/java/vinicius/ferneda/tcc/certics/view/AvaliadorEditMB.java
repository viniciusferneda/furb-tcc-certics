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
@PreviousView("./avaliador_list.jsf")
public class AvaliadorEditMB extends AbstractEditPageBean<AvaliadorEntity, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private AvaliadorBC avaliadorBC;

	@Inject
	private EnderecoBC enderecoBC;
	
	@Inject
	private UsuarioBC usuarioBC;
	
	public List<SelectItem> getSexo() {
		return avaliadorBC.getEnumSexo();
	}
	
	public List<SelectItem> getUf() {
		return avaliadorBC.getEnumUF();
	}
	
	@Override
	@Transactional
	public String delete() {
		this.avaliadorBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		//grava Endereco
		this.enderecoBC.insert(this.getBean().getEndereco());
		
		//grava Usuario
		this.usuarioBC.insert(this.getBean().getUsuario());
		
		//grava Avaliador
		this.avaliadorBC.insert(this.getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.avaliadorBC.update(this.getBean());
		return getPreviousView();
	}
	
	@Override
	protected AvaliadorEntity handleLoad(Long id) {
		return this.avaliadorBC.load(id);
	}	
	
	@Override
	protected AvaliadorEntity createBean() {
		AvaliadorEntity avaliador = super.createBean();
		avaliador.setEndereco(new EnderecoEntity());
		avaliador.setUsuario(new UsuarioEntity());
		return avaliador;
	}
}