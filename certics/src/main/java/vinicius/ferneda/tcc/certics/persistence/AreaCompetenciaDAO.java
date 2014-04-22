package vinicius.ferneda.tcc.certics.persistence;

import java.util.List;

import javax.persistence.Query;

import vinicius.ferneda.tcc.certics.constant.EnumVersaoCertics;
import vinicius.ferneda.tcc.certics.domain.AreaCompetenciaEntity;
import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

@PersistenceController
public class AreaCompetenciaDAO extends JPACrud<AreaCompetenciaEntity, Long> {

	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unchecked")
	public List<AreaCompetenciaEntity> findByVersaoCerticsAndAvaliacaoID(Long avaliacaoID, EnumVersaoCertics versaoCetics){
		Query query = getEntityManager().createNamedQuery("AreaCompetenciaEntity.findByVersaoCerticsAndAvaliacaoID");
		query.setParameter("avaliacaoID", avaliacaoID);
		query.setParameter("versaoCertics", versaoCetics);
		return query.getResultList();
    }
	
}
