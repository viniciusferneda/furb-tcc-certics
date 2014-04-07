package vinicius.ferneda.tcc.certics.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TB_USUARIO")
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "USU_ID", nullable=false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name="USU_EMAIL", length=255)
	private String email;
	
	@Column(name="USU_SENHA", length=255)
	private String senha;
	
	@ManyToOne
	@JoinColumn(name="USU_PROID")
	private Profissional profissional;

	@ManyToOne
	@JoinColumn(name="USU_AVRID")
	private Avaliador avaliador;

	public Usuario(){
	}
	
	public Usuario(String email, String senha, Profissional profissional, Avaliador avaliador) {
		this.email = email;
		this.senha = senha;
		this.profissional = profissional;
		this.avaliador = avaliador;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Profissional getProfissional() {
		return profissional;
	}

	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}

	public Avaliador getAvaliador() {
		return avaliador;
	}

	public void setAvaliador(Avaliador avaliador) {
		this.avaliador = avaliador;
	}

}
