package vinicius.ferneda.tcc.certics.domain;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_VERSAO_CERTICS")
@SequenceGenerator(name="VCE_ID", sequenceName="SEQ_VCE_ID", allocationSize=1)
@NamedQueries({
    @NamedQuery(name="VersaoCerticsEntity.findById", 
    		query="SELECT obj "
    				+ " FROM VersaoCerticsEntity obj "
    				+ " WHERE obj.id = :id"),
    @NamedQuery(name="VersaoCerticsEntity.findByNome",
    		query="SELECT obj "
    				+ " FROM VersaoCerticsEntity obj "
    				+ " WHERE obj.nome = :nome")
})
public class VersaoCerticsEntity extends VersaoCertics{

	private static final long serialVersionUID = 1L;
	
	public VersaoCerticsEntity(){
	}
	
	public VersaoCerticsEntity(String nome, String descricao){
		setNome(nome);
		setDescricao(descricao);
	}
}
