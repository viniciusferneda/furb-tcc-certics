package vinicius.ferneda.tcc.certics.domain;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import vinicius.ferneda.tcc.certics.constant.EnumUF;

@Entity
@Table(name="TB_ENDERECO")
@NamedQueries({
    @NamedQuery(name="EnderecoEntity.findById",
    	query = "SELECT obj FROM EnderecoEntity obj "
    			+ " WHERE obj.id = :id"),
    
    @NamedQuery(name="EnderecoEntity.findByCep",
    	query = "SELECT obj FROM EnderecoEntity obj "
    			+ " WHERE obj.cep = :cep"),
    
    @NamedQuery(name="EnderecoEntity.findByAvaliadorID", 
    	query = "SELECT obj FROM EnderecoEntity obj "
    			+ " inner join obj.pessoaFisica pes "
    			+ " WHERE pes.id = :avaliadorID"),
    			
	@NamedQuery(name="EnderecoEntity.findByProfissionalID", 
		query = "SELECT obj FROM EnderecoEntity obj "
			+ " inner join obj.pessoaFisica pes "
			+ " WHERE pes.id = :profissionalID"),
			
	@NamedQuery(name="EnderecoEntity.findByOrgnizacaoSolicitanteID", 
		query = "SELECT obj FROM EnderecoEntity obj "
			+ " inner join obj.organizacaoSolicitante ors "
			+ " WHERE ors.id = :organizacaoSolicitanteID")
})
public class EnderecoEntity extends Endereco {

	private static final long serialVersionUID = 1L;
	
	public EnderecoEntity(){
	}
	
	public EnderecoEntity(String cep, String logradouro, Integer numero, String complemento, String bairro, String cidade, EnumUF uf, String pais) {
		setCep(cep);
		setLogradouro(logradouro);
		setNumero(numero);
		setComplemento(complemento);
		setBairro(bairro);
		setCidade(cidade);
		setUf(uf);
		setPais(pais);
	}
	
}
