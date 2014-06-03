package vinicius.ferneda.tcc.certics.persistence;

import javax.inject.Inject;
import javax.persistence.Query;

import vinicius.ferneda.tcc.certics.domain.PessoaFisicaEntity;
import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.gov.frameworkdemoiselle.util.ResourceBundle;

@PersistenceController
public class PessoaFisicaDAO extends JPACrud<PessoaFisicaEntity, Long>{

	private static final long serialVersionUID = 1L;
	
	@Inject
    private ResourceBundle rb;
    
	@Inject
	private UsuarioDAO usuarioDAO;
	
	/**
	 * 
	 * @param id
	 * @return
	 * @throws Exception
	 */
	public PessoaFisicaEntity findById(Long id) throws Exception{
    	return (PessoaFisicaEntity) getEntityManager().createNamedQuery("PessoaFisicaEntity.findById").setParameter("id", id).getSingleResult();
    }
	
    /**
     *
     * @param email
     * @return
     * @throws Exception
     */
    public PessoaFisicaEntity findByEmail(String email) throws Exception{
    	return (PessoaFisicaEntity) getEntityManager().createNamedQuery("PessoaFisicaEntity.findByEmail").setParameter("email", email).getSingleResult();
    }

    /**
     * 
     * @param usuarioID
     * @param papelUsuario
     * @return
     * @throws Exception
     */
    public Boolean hasRole(Long usuarioID, Short papelUsuario) throws Exception{
    	Query query = getEntityManager().createNamedQuery("PessoaFisicaEntity.hasRole");
    	query.setParameter("usuarioID", usuarioID);
    	query.setParameter("papelUsuario", papelUsuario);
    	Long count = (Long) query.getSingleResult();
    	return count.intValue() > 0;
    }
    
}
