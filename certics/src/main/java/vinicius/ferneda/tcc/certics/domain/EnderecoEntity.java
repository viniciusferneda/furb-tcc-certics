package vinicius.ferneda.tcc.certics.domain;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import vinicius.ferneda.tcc.certics.constant.EnumUF;

@Entity
@Table(name="TB_ENDERECO")
@SequenceGenerator(name="END_ID", sequenceName="SEQ_END_ID", allocationSize=1)
@NamedQueries({
    @NamedQuery(name="EnderecoEntity.findById",
    	query = "SELECT obj FROM EnderecoEntity obj "
    			+ " WHERE obj.id = :id"),
    
    @NamedQuery(name="EnderecoEntity.findByCep",
    	query = "SELECT obj FROM EnderecoEntity obj "
    			+ " WHERE obj.cep = :cep")
    
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
