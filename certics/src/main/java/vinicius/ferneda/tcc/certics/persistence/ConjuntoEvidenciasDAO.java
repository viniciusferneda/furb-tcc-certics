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
	public ConjuntoEvidenciasEntity findByResultadoEsperadoID(Long resultadoEsperadoID){
		Query query = getEntityManager().createNamedQuery("ConjuntoEvidenciasEntity.findByResultadoEsperadoID");
		query.setParameter("resultadoEsperadoID", resultadoEsperadoID);
		List<ConjuntoEvidenciasEntity> lConjuntoEvidencias = query.getResultList();
		if(lConjuntoEvidencias != null && !lConjuntoEvidencias.isEmpty()){
			return lConjuntoEvidencias.get(0);
		}else{
			return null;
		}
    }
	
	@SuppressWarnings("unchecked")
	public List<ConjuntoEvidenciasEntity> findByAvaliacaoID(Long avaliacaoID){
		return (List<ConjuntoEvidenciasEntity>) getEntityManager().createNamedQuery("ConjuntoEvidenciasEntity.findByAvaliacaoID").setParameter("avaliacaoID", avaliacaoID);
    }

}
