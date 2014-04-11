package vinicius.ferneda.tcc.certics.persistence;

import java.util.List;

import vinicius.ferneda.tcc.certics.domain.Endereco;
import vinicius.ferneda.tcc.certics.domain.EnderecoEntity;
import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

@PersistenceController
public class EnderecoDAO extends JPACrud<Endereco, Long> {

	private static final long serialVersionUID = 1L;
	
	@SuppressWarnings("unchecked")
	public EnderecoEntity findByAvaliadorID(Long avaliadorID){
		List<EnderecoEntity> lEnderecos = getEntityManager().createNamedQuery("EnderecoEntity.findByAvaliadorID").setParameter("avaliadorID", avaliadorID).getResultList();
		if(lEnderecos != null && !lEnderecos.isEmpty()){
			return lEnderecos.get(0);
		}else{
			return null;
		}
    }
	
	@SuppressWarnings("unchecked")
	public EnderecoEntity findByProfissionalID(Long profissionalID){
		List<EnderecoEntity> lEnderecos = getEntityManager().createNamedQuery("EnderecoEntity.findByProfissionalID").setParameter("profissionalID", profissionalID).getResultList();
		if(lEnderecos != null && !lEnderecos.isEmpty()){
			return lEnderecos.get(0);
		}else{
			return null;
		}
    }
	
	@SuppressWarnings("unchecked")
	public EnderecoEntity findByOrgnizacaoSolicitanteID(Long organizacaoSolicitanteID){
		List<EnderecoEntity> lEnderecos = getEntityManager().createNamedQuery("EnderecoEntity.findByOrgnizacaoSolicitanteID").setParameter("organizacaoSolicitanteID", organizacaoSolicitanteID).getResultList();
		if(lEnderecos != null && !lEnderecos.isEmpty()){
			return lEnderecos.get(0);
		}else{
			return null;
		}
    }
}
