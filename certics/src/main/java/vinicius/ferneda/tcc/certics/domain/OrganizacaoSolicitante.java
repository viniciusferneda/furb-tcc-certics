package vinicius.ferneda.tcc.certics.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="TB_ORGANIZACAO_SOLICITANTE")
public class OrganizacaoSolicitante implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ORS_ID", nullable=false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name="ORS_NOME", nullable=false, length=255)
	private String nome;
	
	@Column(name="ORS_RAZAO_SOCIAL", nullable=false, length=255)
	private String razaoSocial;
	
	@Column(name="ORS_CNPJ", nullable=false, length=20)
	private String cnpj;
	
	@Column(name="ORS_FONE_1", length=20)
	private String fone1;
	
	@Column(name="ORS_FONE_2", length=20)
	private String fone2;

	@Column(name="ORS_ENDID")
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private Endereco endereco;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="PES_ORSID")
	private List<Profissional> profissionais = new ArrayList<Profissional>();

	public OrganizacaoSolicitante(){
	}
	
	public OrganizacaoSolicitante(String nome, String razaoSocial, String cnpj, String fone1, String fone2, Endereco endereco) {
		this.nome = nome;
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.fone1 = fone1;
		this.fone2 = fone2;
		this.endereco = endereco;
	}

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

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
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

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Profissional> getProfissionais() {
		return profissionais;
	}

	public void setProfissionais(List<Profissional> profissionais) {
		this.profissionais = profissionais;
	}
	
}
