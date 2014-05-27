package vinicius.ferneda.tcc.certics.view;

import javax.inject.Inject;

import vinicius.ferneda.tcc.certics.business.UsuarioBC;
import vinicius.ferneda.tcc.certics.domain.PessoaFisicaEntity;
import vinicius.ferneda.tcc.certics.domain.UsuarioEntity;
import vinicius.ferneda.tcc.certics.persistence.PessoaFisicaDAO;
import vinicius.ferneda.tcc.certics.security.CatalogoAuthenticator;
import vinicius.ferneda.tcc.certics.security.Identity;
import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;

@ViewController
@PreviousView("./login.jsf")
@NextView("./index.jsf")
public class UsuarioEditMB extends AbstractEditPageBean<UsuarioEntity, Long> {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private UsuarioBC usuarioBC;
	
    @Inject
    private CatalogoAuthenticator catalogoAuthenticator;

    @Inject
    private MessageContext messageContext;
    
    @Inject
    private Identity identity;
    
    @Inject
    private PessoaFisicaDAO pessoaFisicaDAO;
    
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

	public PessoaFisicaEntity getPessoaFisicaEntity() {
		if(this.identity.getId() != null && !"".equals(this.identity.getId())){
			try {
				return this.pessoaFisicaDAO.findById(Long.valueOf(this.identity.getId()));
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return new PessoaFisicaEntity();
	}
	
}