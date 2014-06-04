package vinicius.ferneda.tcc.certics.persistence;

import java.util.List;

import javax.persistence.Query;

import vinicius.ferneda.tcc.certics.domain.VersaoCerticsAreaCompetenciaEntity;
import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

@PersistenceController
public class VersaoCerticsAreaCompetenciaEntityDAO extends JPACrud<VersaoCerticsAreaCompetenciaEntity, Long> {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Verifica se existe alguma versão vinculada ao resultado esperado
	 * 
	 * @param versaoID
	 * @param areaCompetenciaID
	 * @return
	 */
	public boolean possuiVersaoCertics(Long versaoID, Long areaCompetenciaID){
		Long count = (Long) getEntityManager().createNamedQuery("VersaoCerticsAreaCompetenciaEntity.possuiVersaoCertics").setParameter("versaoID", versaoID).setParameter("areaCompetenciaID", areaCompetenciaID).getSingleResult();
		return count.intValue() > 0;
    }
	
	/**
	 * Retorna uma versão certics vinculada ao resultado esperado
	 * 
	 * @param versaoCerticsID
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public VersaoCerticsAreaCompetenciaEntity findByVersaoCerticsID(Long versaoCerticsID, Long areaCompetenciaID){
		Query query = getEntityManager().createNamedQuery("VersaoCerticsAreaCompetenciaEntity.findByVersaoCerticsID");
		query.setParameter("versaoCerticsID", versaoCerticsID);
		query.setParameter("areaCompetenciaID", areaCompetenciaID);
		List<VersaoCerticsAreaCompetenciaEntity> lVersoes = query.getResultList();
		if(lVersoes != null && !lVersoes.isEmpty()){
			return lVersoes.get(0);
		}else{
			return null;
		}
	}
	
}
