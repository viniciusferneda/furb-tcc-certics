package vinicius.ferneda.tcc.certics.security;

import br.gov.frameworkdemoiselle.security.AuthenticationException;
import br.gov.frameworkdemoiselle.security.Authorizer;
import br.gov.frameworkdemoiselle.util.ResourceBundle;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.inject.Inject;

import vinicius.ferneda.tcc.certics.constant.EnumOperacoes;
import vinicius.ferneda.tcc.certics.constant.EnumRecursos;

public class CatalogoAuthorizer implements Authorizer {
	 
	private static final long serialVersionUID = 1L;

	@Inject
    private Identity identity;

    @Inject
    private ResourceBundle rb;

    @Override
    public boolean hasRole(String role) throws Exception {
        try {
            return role.equals(identity.getAttribute("role"));
        } catch (Exception ex) {
            throw new AuthenticationException(rb.getString("controle.acesso.tem.papel.excecao"), ex);
        }
    }

	@Override
	@SuppressWarnings("unchecked")
    public boolean hasPermission(String resource, String operation) throws Exception {
        try {
        	Map<EnumRecursos, EnumOperacoes> recursoOperacoes = (Map<EnumRecursos, EnumOperacoes>) identity.getAttribute("recursos_operacoes");

            List<String> operacoes = new ArrayList<String>();
            operacoes.add(operation);

            EnumRecursos recurso = EnumRecursos.valueOf(resource);
            EnumOperacoes operacao = EnumOperacoes.valueOf(operation);

            for (Map.Entry<EnumRecursos, EnumOperacoes> entry : recursoOperacoes.entrySet()) {
                if (recurso.equals(entry.getKey()) && operacao.equals(entry.getValue())) {
                    return true;
                }
            }

            return false;
        } catch (Exception ex) {
            throw new AuthenticationException(rb.getString("controle.acesso.tem.permissao.excecao"), ex);
        }
    }

}
