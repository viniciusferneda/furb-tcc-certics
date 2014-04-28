package vinicius.ferneda.tcc.certics.security;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import vinicius.ferneda.tcc.certics.constant.EnumOperacoes;
import vinicius.ferneda.tcc.certics.constant.EnumPapelUsuario;
import vinicius.ferneda.tcc.certics.constant.EnumRecursos;
import vinicius.ferneda.tcc.certics.domain.PessoaFisicaEntity;
import vinicius.ferneda.tcc.certics.persistence.PessoaFisicaDAO;
import vinicius.ferneda.tcc.certics.util.CriptografiaUtil;
import br.gov.frameworkdemoiselle.security.AuthenticationException;
import br.gov.frameworkdemoiselle.security.Authenticator;
import br.gov.frameworkdemoiselle.security.SecurityContext;
import br.gov.frameworkdemoiselle.security.User;
import br.gov.frameworkdemoiselle.util.ResourceBundle;

public class CatalogoAuthenticator implements Authenticator {

	private static final long serialVersionUID = 1L;

	@Inject
    private SecurityContext securityContext;

    @Inject
    private Identity identity;

    @Inject
    private PessoaFisicaDAO pessoaFisicaDAO;

    @Inject
    private ResourceBundle rb;

    @Override
    public void authenticate() throws Exception {
        try {
        	PessoaFisicaEntity pessoaFisica = this.pessoaFisicaDAO.findByEmail((String) identity.getEmailUsuario());

	        if (pessoaFisica == null) {
	            throw new AuthenticationException(rb.getString("login.falhou"));
	        } else {
	            if (pessoaFisica.getUsuario().getSenha().equals(CriptografiaUtil.getCodigoMd5((String) identity.getSenha()))) {
	                throw new AuthenticationException(rb.getString("login.falhou"));
	            }
	        }
	
	        this.identity.setAttribute("id", pessoaFisica.getId());
	        this.identity.setAttribute("username", pessoaFisica.getUsuario().getEmail());
	        this.identity.setAttribute("ativo", pessoaFisica.getUsuario().getAtivo());
	        this.identity.setAttribute("role", pessoaFisica.getUsuario().getPapelUsuario().getNome());
	        this.identity.setAttribute("recursos_operacoes", defineRecursosOperacoes(pessoaFisica.getUsuario().getPapelUsuario()));
	        this.identity.setAttribute("isLogged", true);
        } catch (Exception ex) {
            throw new AuthenticationException(rb.getString("login.usuario.nao.existe"), ex);
        }

    }

    private Map<EnumRecursos, EnumOperacoes> defineRecursosOperacoes(EnumPapelUsuario papelUsuario) {
    	Map<EnumRecursos, EnumOperacoes> mapRecursosOperacoes = new HashMap<EnumRecursos, EnumOperacoes>();
    	switch (papelUsuario) {
		case ADM:
			for (EnumRecursos recurso : EnumRecursos.values()) {
				for (EnumOperacoes operacao : EnumOperacoes.values()) {
					mapRecursosOperacoes.put(recurso, operacao);
				}
			}
			break;
		case AVALIADOR:
			for (EnumOperacoes operacao : EnumOperacoes.values()) {
				mapRecursosOperacoes.put(EnumRecursos.AREA_COMPETENCIA, operacao);
				mapRecursosOperacoes.put(EnumRecursos.AVALIACAO, operacao);
				mapRecursosOperacoes.put(EnumRecursos.AVALIADOR, operacao);
				mapRecursosOperacoes.put(EnumRecursos.CONJUNTO_EVIDENCIAS, operacao);
				mapRecursosOperacoes.put(EnumRecursos.ENDERECO, operacao);
				mapRecursosOperacoes.put(EnumRecursos.ORGANIZACAO_SOLICITANTE, operacao);
				mapRecursosOperacoes.put(EnumRecursos.PROFISSIONAL, operacao);
				mapRecursosOperacoes.put(EnumRecursos.RESULTADO_ESPERADO, operacao);
				mapRecursosOperacoes.put(EnumRecursos.SOFTWARE, operacao);
				mapRecursosOperacoes.put(EnumRecursos.USUARIO, operacao);
			}
			break;
		case AVALIADO:
			for (EnumOperacoes operacao : EnumOperacoes.values()) {
				mapRecursosOperacoes.put(EnumRecursos.CONJUNTO_EVIDENCIAS, operacao);
				mapRecursosOperacoes.put(EnumRecursos.ENDERECO, operacao);
				mapRecursosOperacoes.put(EnumRecursos.EVIDENCIA, operacao);
				mapRecursosOperacoes.put(EnumRecursos.EVIDENCIA_PROFISSIONAL, operacao);
				mapRecursosOperacoes.put(EnumRecursos.LICAO_APRENDIDA, operacao);
				mapRecursosOperacoes.put(EnumRecursos.PROFISSIONAL, operacao);
				mapRecursosOperacoes.put(EnumRecursos.RESPOSTA_EVIDENCIA, operacao);
				mapRecursosOperacoes.put(EnumRecursos.USUARIO, operacao);
			}
			mapRecursosOperacoes.put(EnumRecursos.ORGANIZACAO_SOLICITANTE, EnumOperacoes.LIST);
			mapRecursosOperacoes.put(EnumRecursos.ORGANIZACAO_SOLICITANTE, EnumOperacoes.UPDATE);
			break;
		default:
			break;
		}
    	
    	return mapRecursosOperacoes;
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
