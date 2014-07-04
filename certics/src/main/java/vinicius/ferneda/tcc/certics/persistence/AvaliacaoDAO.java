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
	public List<AvaliacaoEntity> findByAvaliadorID(Long avaliadorID){
		Query query = getEntityManager().createNamedQuery("AvaliacaoEntity.findByAvaliadorID");
		query.setParameter("avaliadorID", avaliadorID);
		List<AvaliacaoEntity> lAvaliacoes = query.getResultList();
		return lAvaliacoes;
    }
	
	@SuppressWarnings("unchecked")
	public List<AvaliacaoEntity> findByOrganizacaoID(Long organizacaoID){
		Query query = getEntityManager().createNamedQuery("AvaliacaoEntity.findByOrganizacaoID");
		query.setParameter("organizacaoID", organizacaoID);
		List<AvaliacaoEntity> lAvaliacoes = query.getResultList();
		return lAvaliacoes;
    }
	
}
