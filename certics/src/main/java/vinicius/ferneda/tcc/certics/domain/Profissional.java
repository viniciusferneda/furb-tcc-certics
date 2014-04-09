package vinicius.ferneda.tcc.certics.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import vinicius.ferneda.tcc.certics.constant.EnumSexo;

@Entity
@Table(name="TB_PESSOA_FISICA")
public class Profissional extends PessoaFisica implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name="PES_VINCULO_ATUAL", nullable=false, length=255)
	private String vinculoAtual;

	@Column(name="PES_RESORG", length=1)
	private Integer responsavelOrganizacao;
	
	@ManyToOne 
	@JoinColumn(name="PES_ORSID", nullable=false)
	private OrganizacaoSolicitante organizacaoSolicitante;

	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="USU_PROID")
	private List<UsuarioEntity> usuarios = new ArrayList<UsuarioEntity>();
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="EPR_PROID")
	private List<EvidenciaProfissional> profissionais = new ArrayList<EvidenciaProfissional>();
	
	public Profissional(){
	}
	
	public Profissional(String vinculoAtual, Integer responsavelOrganizacao, OrganizacaoSolicitante organizacaoSolicitante,
			String nome, String cpf, String rg, EnumSexo sexo, Date dataNascimento, String fone1, String fone2, Endereco endereco) {
		super(nome, cpf, rg, sexo, dataNascimento, fone1, fone2, endereco);
		this.vinculoAtual = vinculoAtual;
		this.responsavelOrganizacao = responsavelOrganizacao;
		this.organizacaoSolicitante = organizacaoSolicitante;
	}

	public String getVinculoAtual() {
		return vinculoAtual;
	}

	public void setVinculoAtual(String vinculoAtual) {
		this.vinculoAtual = vinculoAtual;
	}

	public Integer getResponsavelOrganizacao() {
		return responsavelOrganizacao;
	}

	public void setResponsavelOrganizacao(Integer responsavelOrganizacao) {
		this.responsavelOrganizacao = responsavelOrganizacao;
	}

	public OrganizacaoSolicitante getOrganizacaoSolicitante() {
		return organizacaoSolicitante;
	}

	public void setOrganizacaoSolicitante(OrganizacaoSolicitante organizacaoSolicitante) {
		this.organizacaoSolicitante = organizacaoSolicitante;
	}

	public List<UsuarioEntity> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(List<UsuarioEntity> usuarios) {
		this.usuarios = usuarios;
	}

	public List<EvidenciaProfissional> getProfissionais() {
		return profissionais;
	}

	public void setProfissionais(List<EvidenciaProfissional> profissionais) {
		this.profissionais = profissionais;
	}
	
}
