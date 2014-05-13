package vinicius.ferneda.tcc.certics.persistence;

import java.util.List;

import javax.persistence.Query;

import vinicius.ferneda.tcc.certics.domain.ConjuntoEvidenciasEntity;
import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

@PersistenceController
public class ConjuntoEvidenciasDAO extends JPACrud<ConjuntoEvidenciasEntity, Long> {

	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unchecked")
	public List<ConjuntoEvidenciasEntity> findByResultadoEsperadoID(Long resultadoEsperadoID){
		Query query = getEntityManager().createNamedQuery("ConjuntoEvidenciasEntity.findByResultadoEsperadoID");
		query.setParameter("resultadoEsperadoID", resultadoEsperadoID);
		return query.getResultList();
    }
}
