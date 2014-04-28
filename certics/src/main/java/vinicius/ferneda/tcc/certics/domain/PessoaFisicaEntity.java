package vinicius.ferneda.tcc.certics.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import vinicius.ferneda.tcc.certics.constant.EnumSexo;

@Entity
@Table(name="TB_PESSOA_FISICA")
@SequenceGenerator(name="PES_ID", sequenceName="PES_ID", allocationSize=1)
@NamedQueries({
	@NamedQuery(name="PessoaFisicaEntity.findById", 
	    query="SELECT obj "
	    		+ " FROM PessoaFisicaEntity obj "
	    		+ " WHERE obj.id = :id"),
    	
    @NamedQuery(name="PessoaFisicaEntity.findByNome", 
    	query="SELECT obj "
    			+ " FROM PessoaFisicaEntity obj "
    			+ " WHERE obj.nome = :nome"),
    	
    @NamedQuery(name="PessoaFisicaEntity.findByAminesia",
    	query="SELECT obj "
    			+ " FROM PessoaFisicaEntity obj "
    			+ " INNER JOIN obj.usuario usu "
    			+ " WHERE usu.aminesia = :aminesia"),
    	
    @NamedQuery(name="PessoaFisicaEntity.findBySenha",
    	query="SELECT obj "
    			+ " FROM PessoaFisicaEntity obj "
    			+ " INNER JOIN obj.usuario usu "
    			+ " WHERE usu.senha = :senha"),
    	
    @NamedQuery(name="PessoaFisicaEntity.findByEmail",
    	query="SELECT obj "
    			+ " FROM PessoaFisicaEntity obj "
    			+ " INNER JOIN obj.usuario usu "
    			+ " WHERE usu.email = :email"),
    			
    @NamedQuery(name="PessoaFisicaEntity.hasRole",
    	query="SELECT COUNT(obj.id) "
    			+ " FROM PessoaFisicaEntity obj "
    			+ " INNER JOIN obj.usuario usu "
    			+ " WHERE obj.id = :usuarioID"
    			+ "		AND usu.papelUsuario = :papelUsuario")
})
public class PessoaFisicaEntity extends PessoaFisica {

	public PessoaFisicaEntity(){
	}
	
	public PessoaFisicaEntity(String nome, String cpf, String rg, EnumSexo sexo, Date dataNascimento, String fone1, String fone2, Endereco endereco) {
		setNome(nome);
		setCpf(cpf);
		setRg(rg);
		setSexo(sexo);
		setDataNascimento(dataNascimento);
		setFone1(fone1);
		setFone2(fone2);
	}
	
}
