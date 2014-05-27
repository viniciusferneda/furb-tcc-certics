package vinicius.ferneda.tcc.certics.persistence;

import vinicius.ferneda.tcc.certics.domain.OrganizacaoSolicitanteEntity;
import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

@PersistenceController
public class OrganizacaoSolicitanteDAO extends JPACrud<OrganizacaoSolicitanteEntity, Long> {

	private static final long serialVersionUID = 1L;
	
	/**
	 * @param id
	 * @return
	 */
	public OrganizacaoSolicitanteEntity findById(Long id){
    	return (OrganizacaoSolicitanteEntity) getEntityManager().createNamedQuery("OrganizacaoSolicitanteEntity.findById").setParameter("id", id).getSingleResult();
    }
	
	/**
	 * @param profissionalID
	 * @return
	 */
	public OrganizacaoSolicitanteEntity findByProfissionalID(Long profissionalID){
    	return (OrganizacaoSolicitanteEntity) getEntityManager().createNamedQuery("OrganizacaoSolicitanteEntity.findByProfissionalID").setParameter("profissionalID", profissionalID).getSingleResult();
    }
}
