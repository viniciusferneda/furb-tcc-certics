package vinicius.ferneda.tcc.certics.domain;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_USUARIO")
@SequenceGenerator(name="USU_ID", sequenceName="USU_ID")
@NamedQueries({
    @NamedQuery(name = "UsuarioEntity.findById", query = "SELECT u FROM UsuarioEntity u WHERE u.id = :id"),
    @NamedQuery(name = "UsuarioEntity.findByEmail", query = "SELECT u FROM UsuarioEntity u WHERE u.email = :email")
})
public class UsuarioEntity extends Usuario{

	private static final long serialVersionUID = 1L;
	
	public UsuarioEntity(){
	}
	
	public UsuarioEntity(String email, String senha) {
		setEmail(email);
		setSenha(senha);
	}
	
}
