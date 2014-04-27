package vinicius.ferneda.tcc.certics.security;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import vinicius.ferneda.tcc.certics.domain.Usuario;
import vinicius.ferneda.tcc.certics.persistence.UsuarioDAO;
import vinicius.ferneda.tcc.certics.util.CriptografiaUtil;
import br.gov.frameworkdemoiselle.security.AuthenticationException;
import br.gov.frameworkdemoiselle.security.Authenticator;
import br.gov.frameworkdemoiselle.security.SecurityContext;
import br.gov.frameworkdemoiselle.security.User;
import br.gov.frameworkdemoiselle.util.ResourceBundle;

/**
 *
 * @author 70744416353
 */
public class CatalogoAuthenticator implements Authenticator {

	private static final long serialVersionUID = 1L;

	@Inject
    private SecurityContext securityContext;

    @Inject
    private Identity identity;

    @Inject
    private UsuarioDAO usuarioDAO;

    @Inject
    private ResourceBundle rb;

    @Override
    public void authenticate() throws Exception {
        Usuario usuario;
        Map<Integer, Integer> recursosOperacoes = new HashMap<Integer, Integer>();

        /*try {
            usuario = usuarioDAO.findByUserName((String) identity.getUsuario());
            List<UsuarioRecurso> recursosUsuario = usuarioRecursoDAO.findByUsuario(usuario.getId());
            Iterator<UsuarioRecurso> it = recursosUsuario.iterator();
            while (it.hasNext()) {
                UsuarioRecurso usuarioRecurso = it.next();
                recursosOperacoes.put(usuarioRecurso.getUsuarioRecursosPK().getRecursos(), usuarioRecurso.getOperacao());
            }

        } catch (Exception ex) {
            throw new AuthenticationException(rb.getString("login.usuario.nao.existe"), ex);
        }

        if (usuario == null) {
            throw new AuthenticationException(rb.getString("login.falhou"));
        } else {
            if (!usuario.getAminesia().isEmpty() && usuario.getSenha().equals(usuario.getAminesia().substring(21, 27))) {
                throw new AuthenticationException(rb.getString("login.alteracao.por.email"));
            }
            if (!usuario.getSenha().equals(CriptografiaUtil.getCodigoMd5((String) identity.getSenha()))) {
                throw new AuthenticationException(rb.getString("login.falhou"));
            }
        }

        this.identity.setAttribute("id", usuario.getId());
        this.identity.setAttribute("username", usuario.getNome());
        this.identity.setAttribute("email", usuario.getEmail());
        this.identity.setAttribute("ativo", usuario.getAtivo());
        this.identity.setAttribute("role", Roles.getRole(usuario.getPapel()).get(0));
        this.identity.setAttribute("recurososOperacoes", recursosOperacoes);
        this.identity.setAttribute("isLogged", true);*/

    }

    @Override
    public User getUser() {
        if (identity.getId() == null || identity.getId().isEmpty())
            return null;
        else
            return identity;
    }

    @Override
    public void unauthenticate() throws Exception {
        this.identity.setAttribute("id", null);
    }

    public boolean loggedIn() {
        return securityContext.isLoggedIn();
    }

    public void login() {
        securityContext.login();
    }

    public void logout() {
        securityContext.logout();
    }

}
