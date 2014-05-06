package vinicius.ferneda.tcc.certics.persistence;

import java.util.List;

import vinicius.ferneda.tcc.certics.domain.ResultadoEsperadoEntity;
import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

@PersistenceController
public class ResultadoEsperadoDAO extends JPACrud<ResultadoEsperadoEntity, Long> {

	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unchecked")
	public List<ResultadoEsperadoEntity> findByVersaoCertics(Long versaoCerticsID){
		return getEntityManager().createNamedQuery("ResultadoEsperadoEntity.findByVersaoCertics").setParameter("versaoCerticsID", versaoCerticsID).getResultList();
    }
	
}
