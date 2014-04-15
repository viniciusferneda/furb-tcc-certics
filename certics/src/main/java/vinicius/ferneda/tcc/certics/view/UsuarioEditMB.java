package vinicius.ferneda.tcc.certics.view;

import javax.inject.Inject;

import vinicius.ferneda.tcc.certics.business.UsuarioBC;
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
	
	@Override
	@Transactional
	public String delete() {
		this.usuarioBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
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
	
}