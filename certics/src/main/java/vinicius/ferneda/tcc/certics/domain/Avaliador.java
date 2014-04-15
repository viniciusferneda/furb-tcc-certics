package vinicius.ferneda.tcc.certics.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

import vinicius.ferneda.tcc.certics.constant.EnumSexo;

@MappedSuperclass
public abstract class Avaliador extends PessoaFisicaEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="AVA_AVRID")
	private List<AvaliacaoEntity> avaliacoes = new ArrayList<AvaliacaoEntity>();
	
	public Avaliador(){
	}
	
	public Avaliador(String nome, String cpf, String rg, EnumSexo sexo, Date dataNascimento, String fone1, String fone2, Endereco endereco) {
		super(nome, cpf, rg, sexo, dataNascimento, fone1, fone2, endereco);
	}

	public List<AvaliacaoEntity> getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(List<AvaliacaoEntity> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}
	
}
