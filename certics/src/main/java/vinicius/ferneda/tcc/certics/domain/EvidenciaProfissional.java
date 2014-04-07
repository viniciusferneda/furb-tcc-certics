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
@Table(name="TB_EVIDENCIA_PROFISSIONAL")
public class EvidenciaProfissional implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="EPR_ID", nullable=false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name="EPR_FAZ_PARTE_ORG", length=1)
	private Integer fazParteOrganizacao;
	
	@Column(name="EPR_ENVOLVIMENTO", length=255)
	private String envolvimento;
	
	@ManyToOne 
	@JoinColumn(name="EPR_REVID", nullable=false)
	private RespostaEvidencia respostaEvidencia;
	
	@ManyToOne 
	@JoinColumn(name="EPR_PROID", nullable=false)
	private Profissional profissional;

	public EvidenciaProfissional(){
	}
	
	public EvidenciaProfissional(Integer fazParteOrganizacao, String envolvimento, RespostaEvidencia respostaEvidencia, Profissional profissional) {
		this.fazParteOrganizacao = fazParteOrganizacao;
		this.envolvimento = envolvimento;
		this.respostaEvidencia = respostaEvidencia;
		this.profissional = profissional;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getFazParteOrganizacao() {
		return fazParteOrganizacao;
	}

	public void setFazParteOrganizacao(Integer fazParteOrganizacao) {
		this.fazParteOrganizacao = fazParteOrganizacao;
	}

	public String getEnvolvimento() {
		return envolvimento;
	}

	public void setEnvolvimento(String envolvimento) {
		this.envolvimento = envolvimento;
	}

	public RespostaEvidencia getRespostaEvidencia() {
		return respostaEvidencia;
	}

	public void setRespostaEvidencia(RespostaEvidencia respostaEvidencia) {
		this.respostaEvidencia = respostaEvidencia;
	}

	public Profissional getProfissional() {
		return profissional;
	}

	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
	}
	
}
