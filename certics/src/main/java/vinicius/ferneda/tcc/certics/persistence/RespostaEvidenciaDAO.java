package vinicius.ferneda.tcc.certics.persistence;

import java.util.List;

import javax.persistence.Query;

import vinicius.ferneda.tcc.certics.domain.RespostaEvidenciaEntity;
import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

@PersistenceController
public class RespostaEvidenciaDAO extends JPACrud<RespostaEvidenciaEntity, Long> {

	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	public List<RespostaEvidenciaEntity> findByConjuntoEvidenciaID(Long conjuntoEvidenciaID){
		Query query = getEntityManager().createNamedQuery("RespostaEvidenciaEntity.findByConjuntoEvidenciaID");
		query.setParameter("conjuntoEvidenciaID", conjuntoEvidenciaID);
		return query.getResultList();
    }

}
