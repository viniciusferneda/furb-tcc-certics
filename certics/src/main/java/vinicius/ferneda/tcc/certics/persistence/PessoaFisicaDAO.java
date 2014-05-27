package vinicius.ferneda.tcc.certics.persistence;

import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import vinicius.ferneda.tcc.certics.domain.PessoaFisicaEntity;
import vinicius.ferneda.tcc.certics.util.CriptografiaUtil;
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
     * @param aminesia
     * @return
     * @throws Exception
     */
    public PessoaFisicaEntity findByAminesia(String aminesia) throws Exception{
    	return (PessoaFisicaEntity) getEntityManager().createNamedQuery("PessoaFisicaEntity.findByAminesia").setParameter("aminesia", aminesia).getSingleResult();
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

    /**
     *
     * @param usuario
     * @param senhaNova
     * @return
     * @throws java.lang.Exception
     */
    public void updatePassWithAminesia(String aminesia, String senhaNova) throws Exception {
        try {
            PessoaFisicaEntity pessoaFisica = findByAminesia(aminesia);
            if (pessoaFisica != null) {
                pessoaFisica.getUsuario().setSenha(CriptografiaUtil.getCodigoMd5(senhaNova));
                this.usuarioDAO.update(pessoaFisica.getUsuario()); 
            }
            else{
                 throw new Exception(rb.getString("aminesia.senha.atual.invalida"));
            }
        } catch (NoResultException e) {
           throw e;
        }
    }
    
}
