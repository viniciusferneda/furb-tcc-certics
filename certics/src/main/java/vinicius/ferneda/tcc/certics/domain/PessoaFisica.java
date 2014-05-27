package vinicius.ferneda.tcc.certics.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import vinicius.ferneda.tcc.certics.constant.EnumSexo;

@MappedSuperclass
public abstract class PessoaFisica{

	@Id
	@Column(name="PES_ID", nullable=false)
	@GeneratedValue(generator="PES_ID", strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="PES_NOME", nullable=false, length=255)
	private String nome;
	
	@Column(name="PES_CPF", nullable=false, length=20)
	private String cpf;
	
	@Column(name="PES_RG", nullable=false, length=20)
	private String rg;
	
	@Column(name="PES_SEXO", nullable=false, length=20)
	@Enumerated(EnumType.STRING)
	private EnumSexo sexo;
	
	@Column(name="PES_DT_NASCIMENTO")
	@Temporal(value=TemporalType.DATE)
	private Date dataNascimento;
	
	@Column(name="PES_FONE_1", length=20)
	private String fone1;
	
	@Column(name="PES_FONE_2", length=20)
	private String fone2;

	@JoinColumn(name="PES_ENDID", nullable=false)
	@OneToOne(fetch=FetchType.LAZY)
	private EnderecoEntity endereco;
	
	@JoinColumn(name="PES_USUID", nullable=false)
	@ManyToOne(fetch=FetchType.LAZY)
	private UsuarioEntity usuario;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public EnumSexo getSexo() {
		return sexo;
	}

	public void setSexo(EnumSexo sexo) {
		this.sexo = sexo;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getFone1() {
		return fone1;
	}

	public void setFone1(String fone1) {
		this.fone1 = fone1;
	}

	public String getFone2() {
		return fone2;
	}

	public void setFone2(String fone2) {
		this.fone2 = fone2;
	}

	public EnderecoEntity getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoEntity endereco) {
		this.endereco = endereco;
	}

	public UsuarioEntity getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}
	
}
