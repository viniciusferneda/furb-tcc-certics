package vinicius.ferneda.tcc.certics.persistence;

import java.util.List;

import javax.persistence.Query;

import vinicius.ferneda.tcc.certics.domain.VersaoCerticsResultadoEsperadoEntity;
import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

@PersistenceController
public class VersaoCerticsResultadoEsperadoEntityDAO extends JPACrud<VersaoCerticsResultadoEsperadoEntity, Long> {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Verifica se existe alguma versão vinculada ao resultado esperado
	 * 
	 * @param versaoID
	 * @param resultadoEsperadoID
	 * @return
	 */
	public boolean possuiVersaoCertics(Long versaoID, Long resultadoEsperadoID){
		Long count = (Long) getEntityManager().createNamedQuery("VersaoCerticsResultadoEsperadoEntity.possuiVersaoCertics").setParameter("versaoID", versaoID).setParameter("resultadoEsperadoID", resultadoEsperadoID).getSingleResult();
		return count.intValue() > 0;
    }
	
	/**
	 * Retorna uma versão certics vinculada ao resultado esperado
	 * 
	 * @param versaoCerticsID
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public VersaoCerticsResultadoEsperadoEntity findByVersaoCerticsID(Long versaoCerticsID, Long resultadoEsperadoID){
		Query query = getEntityManager().createNamedQuery("VersaoCerticsResultadoEsperadoEntity.findByVersaoCerticsID");
		query.setParameter("versaoCerticsID", versaoCerticsID);
		query.setParameter("resultadoEsperadoID", resultadoEsperadoID);
		List<VersaoCerticsResultadoEsperadoEntity> lVersoes = query.getResultList();
		if(lVersoes != null && !lVersoes.isEmpty()){
			return lVersoes.get(0);
		}else{
			return null;
		}
	}
	
}
