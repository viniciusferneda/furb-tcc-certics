package vinicius.ferneda.tcc.certics.view;

import javax.inject.Inject;

import vinicius.ferneda.tcc.certics.business.UsuarioBC;
import vinicius.ferneda.tcc.certics.domain.UsuarioEntity;
import vinicius.ferneda.tcc.certics.security.CatalogoAuthenticator;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.message.MessageContext;
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
    private CatalogoAuthenticator catalogoAuthenticator;

    @Inject
    private MessageContext messageContext;
    
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
	
	public void login() {
        try {
            catalogoAuthenticator.login();
        } catch (Exception e) {
            messageContext.add("Login: ", e.getMessage());
        }
    }

    public void logout() {
        try {
             catalogoAuthenticator.logout();
        } catch (Exception e) {
            messageContext.add("Login: ", e.getMessage());
        }
    }
	
}