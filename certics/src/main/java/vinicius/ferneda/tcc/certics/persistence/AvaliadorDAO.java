package vinicius.ferneda.tcc.certics.persistence;

import java.util.List;

import vinicius.ferneda.tcc.certics.domain.AvaliadorEntity;
import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

@PersistenceController
public class AvaliadorDAO extends JPACrud<AvaliadorEntity, Long> {

	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unchecked")
	public AvaliadorEntity findById(Long idAvaliador){
		List<AvaliadorEntity> lAvaliadores = getEntityManager().createNamedQuery("AvaliadorEntity.findById").setParameter("id", idAvaliador).getResultList();
		if(lAvaliadores != null && !lAvaliadores.isEmpty()){
			return lAvaliadores.get(0);
		}else{
			return null;
		}
    }

	@SuppressWarnings("unchecked")
	public AvaliadorEntity findByUsuarioId(Long idUsuario){
		List<AvaliadorEntity> lAvaliadores = getEntityManager().createNamedQuery("AvaliadorEntity.findByUsuarioId").setParameter("id", idUsuario).getResultList();
		if(lAvaliadores != null && !lAvaliadores.isEmpty()){
			return lAvaliadores.get(0);
		}else{
			return null;
		}
    }

}
