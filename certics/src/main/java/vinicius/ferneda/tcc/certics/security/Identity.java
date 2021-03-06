package vinicius.ferneda.tcc.certics.security;

import java.util.HashMap;
import java.util.Map;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import br.gov.frameworkdemoiselle.security.User;

@Named
@SessionScoped
public class Identity implements User {

    private static final long serialVersionUID = 8003651916557123604L;
    private Map<Object, Object> attribute;

    /*
     * TODO A Funcionalidade do gravação de Cookie não esta funcionando corretamente.
     */
    public Identity() {
        attribute = new HashMap<Object, Object>();
    }

    public String getEmailUsuario() {
        return (String) (attribute.get("username") == null ? "" : attribute.get("username"));
    }

    public void setEmailUsuario(String usuario) {
        attribute.put("username", usuario);
    }

    public String getSenha() {
         return (String) (attribute.get("password") == null ? "" : attribute.get("password"));
    }

    public void setSenha(String senha) {
         attribute.put("password", senha);
    }

    @Override
    public String getId() {
        return (String) (attribute.get("id") == null ? "" : attribute.get("id").toString());
    }

    @Override
    public Object getAttribute(Object key) {
        return attribute.get(key);
    }

    @Override
    public void setAttribute(Object key, Object value) {
        attribute.put(key, value);
    }
}
