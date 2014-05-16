package vinicius.ferneda.tcc.certics.persistence;

import java.util.List;

import javax.persistence.Query;

import vinicius.ferneda.tcc.certics.domain.EvidenciaProfissional;
import vinicius.ferneda.tcc.certics.domain.EvidenciaProfissionalEntity;
import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

@PersistenceController
public class EvidenciaProfissionalDAO extends JPACrud<EvidenciaProfissional, Long> {

	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unchecked")
	public List<EvidenciaProfissionalEntity> findByRespostaEvidenciaID(Long respostaEvidenciaID){
		Query query = getEntityManager().createNamedQuery("EvidenciaProfissionalEntity.findByRespostaEvidenciaID");
		query.setParameter("respostaEvidenciaID", respostaEvidenciaID);
		return query.getResultList();
    }

}
