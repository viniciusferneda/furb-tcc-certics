package vinicius.ferneda.tcc.certics.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class EvidenciaProfissional implements Serializable{

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
	private RespostaEvidenciaEntity respostaEvidencia;
	
	@ManyToOne 
	@JoinColumn(name="EPR_PROID", nullable=false)
	private ProfissionalEntity profissional;

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

	public RespostaEvidenciaEntity getRespostaEvidencia() {
		return respostaEvidencia;
	}

	public void setRespostaEvidencia(RespostaEvidenciaEntity respostaEvidencia) {
		this.respostaEvidencia = respostaEvidencia;
	}

	public ProfissionalEntity getProfissional() {
		return profissional;
	}

	public void setProfissional(ProfissionalEntity profissional) {
		this.profissional = profissional;
	}
	
}
