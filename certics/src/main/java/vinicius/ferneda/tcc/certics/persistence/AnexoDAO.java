package vinicius.ferneda.tcc.certics.persistence;

import java.util.List;

import javax.persistence.Query;

import vinicius.ferneda.tcc.certics.domain.AnexoEntity;
import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

@PersistenceController
public class AnexoDAO extends JPACrud<AnexoEntity, Long> {

	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unchecked")
	public List<AnexoEntity> findByEvidenciaID(Long evidenciaID){
		Query query = getEntityManager().createNamedQuery("AnexoEntity.findByEvidenciaID");
		query.setParameter("evidenciaID", evidenciaID);
		return query.getResultList();
    }
}
