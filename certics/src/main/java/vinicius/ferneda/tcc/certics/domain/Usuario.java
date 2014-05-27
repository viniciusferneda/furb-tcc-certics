package vinicius.ferneda.tcc.certics.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;

import vinicius.ferneda.tcc.certics.constant.EnumPapelUsuario;

@MappedSuperclass
public abstract class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "USU_ID", nullable=false)
	@GeneratedValue(generator="USU_ID", strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="USU_EMAIL", length=255)
	private String email;
	
	@Column(name="USU_SENHA", length=255)
	private String senha;

	@Column(name="USU_PAPEL", nullable=false, length=50)
	@Enumerated(EnumType.STRING)
    private EnumPapelUsuario papelUsuario; 
	
	@Size(min=3, max = 100)
    @Column(name="USU_AMINESIA", length = 100)
    private String aminesia;
	
	@Column(name="USU_ATIVO", nullable=false)
    private Integer ativo = 1;
	
	@JoinColumn(name="PES_USUID")
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<PessoaFisicaEntity> pessoaFisica = new ArrayList<PessoaFisicaEntity>();
	
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

	public EnumPapelUsuario getPapelUsuario() {
		return papelUsuario;
	}

	public void setPapelUsuario(EnumPapelUsuario papelUsuario) {
		this.papelUsuario = papelUsuario;
	}

	public String getAminesia() {
		return aminesia;
	}

	public void setAminesia(String aminesia) {
		this.aminesia = aminesia;
	}

	public Integer getAtivo() {
		return ativo;
	}

	public void setAtivo(Integer ativo) {
		this.ativo = ativo;
	}

	public List<PessoaFisicaEntity> getPessoaFisica() {
		return pessoaFisica;
	}

	public void setPessoaFisica(List<PessoaFisicaEntity> pessoaFisica) {
		this.pessoaFisica = pessoaFisica;
	}
	
}
