package vinicius.ferneda.tcc.certics.persistence;

import java.util.List;

import javax.persistence.Query;

import vinicius.ferneda.tcc.certics.domain.AvaliacaoEntity;
import vinicius.ferneda.tcc.certics.util.DateUtils;
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
	public List<AvaliacaoEntity> findByAvaliadorIDDataAtual(Long avaliadorID){
		Query query = getEntityManager().createNamedQuery("AvaliacaoEntity.findByAvaliadorIDDataAtual");
		query.setParameter("avaliadorID", avaliadorID);
		query.setParameter("dataInicio", DateUtils.getDataAtualSemHora());
		List<AvaliacaoEntity> lAvaliacoes = query.getResultList();
		return lAvaliacoes;
    }
	
	@SuppressWarnings("unchecked")
	public List<AvaliacaoEntity> findByOrganizacaoIDDataAtual(Long organizacaoID){
		Query query = getEntityManager().createNamedQuery("AvaliacaoEntity.findByOrganizacaoIDDataAtual");
		query.setParameter("organizacaoID", organizacaoID);
		query.setParameter("dataInicio", DateUtils.getDataAtualSemHora());
		List<AvaliacaoEntity> lAvaliacoes = query.getResultList();
		return lAvaliacoes;
    }
	
}
