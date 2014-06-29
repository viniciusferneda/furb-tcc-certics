package vinicius.ferneda.tcc.certics.persistence;

import java.util.List;

import javax.persistence.Query;

import vinicius.ferneda.tcc.certics.domain.AvaliacaoEntity;
import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

@PersistenceController
public class AvaliacaoDAO extends JPACrud<AvaliacaoEntity, Long> {

	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unchecked")
	public List<AvaliacaoEntity> findEvidenciasByAvaliacaoID(String avaliacaoID){
		Query query = getEntityManager().createNamedQuery("AvaliacaoEntity.findEvidenciasByAvaliacaoID");
		query.setParameter("avaliacaoID", Long.valueOf(avaliacaoID));
		List<AvaliacaoEntity> lAvaliacoes = query.getResultList();
		return lAvaliacoes;
    }
	
}
