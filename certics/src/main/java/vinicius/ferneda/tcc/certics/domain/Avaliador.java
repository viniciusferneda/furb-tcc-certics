package vinicius.ferneda.tcc.certics.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import vinicius.ferneda.tcc.certics.constant.EnumSexo;

@Entity
@Table(name="TB_PESSOA_FISICA")
public class Avaliador extends PessoaFisica implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="USU_AVRID")
	private List<Usuario> usuarios = new ArrayList<Usuario>();

	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="AVA_AVRID")
	private List<Avaliacao> avaliacoes = new ArrayList<Avaliacao>();
	
	public Avaliador(){
	}
	
	public Avaliador(String nome, String cpf, String rg, EnumSexo sexo, Date dataNascimento, String fone1, String fone2, Endereco endereco) {
		super(nome, cpf, rg, sexo, dataNascimento, fone1, fone2, endereco);
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public List<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(List<Avaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}
	
}
