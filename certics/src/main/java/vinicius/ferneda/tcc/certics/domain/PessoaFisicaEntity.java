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
@SequenceGenerator(name="PES_ID", sequenceName="PES_ID")
@NamedQueries({
	@NamedQuery(name="PessoaFisicaEntity.findById", 
	    	query = "SELECT avr FROM PessoaFisicaEntity avr WHERE avr.id = :id")
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
