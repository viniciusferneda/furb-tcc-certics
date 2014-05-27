package vinicius.ferneda.tcc.certics.persistence;

import vinicius.ferneda.tcc.certics.domain.ProfissionalEntity;
import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

@PersistenceController
public class ProfissionalDAO extends JPACrud<ProfissionalEntity, Long> {

	private static final long serialVersionUID = 1L;
	
	/**
	 * @param id
	 * @return
	 */
	public ProfissionalEntity findById(Long id){
    	return (ProfissionalEntity) getEntityManager().createNamedQuery("ProfissionalEntity.findById").setParameter("id", id).getSingleResult();
    }
}
