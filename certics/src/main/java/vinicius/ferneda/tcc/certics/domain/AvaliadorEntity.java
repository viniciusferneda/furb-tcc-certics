package vinicius.ferneda.tcc.certics.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import vinicius.ferneda.tcc.certics.constant.EnumSexo;

@Entity
@Table(name="TB_PESSOA_FISICA")
@NamedQueries({
    @NamedQuery(name="AvaliadorEntity.findById", 
    	query = "SELECT avr FROM AvaliadorEntity avr WHERE avr.id = :id"),
    	
    @NamedQuery(name="AvaliadorEntity.findByEmail",
    	query = "SELECT avr FROM AvaliadorEntity avr WHERE avr.nome = :nome")
    		
})
public class AvaliadorEntity extends Avaliador{

	private static final long serialVersionUID = 1L;

	public AvaliadorEntity(){
		super();
	}
	
	public AvaliadorEntity(String nome, String cpf, String rg, EnumSexo sexo, Date dataNascimento, String fone1, String fone2, Endereco endereco) {
		super(nome, cpf, rg, sexo, dataNascimento, fone1, fone2, endereco);
	}
	
}
