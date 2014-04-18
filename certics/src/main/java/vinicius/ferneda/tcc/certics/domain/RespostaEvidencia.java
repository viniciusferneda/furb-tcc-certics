package vinicius.ferneda.tcc.certics.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

@MappedSuperclass
public abstract class RespostaEvidencia implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="REV_ID", nullable=false)
	@GeneratedValue(generator="REV_ID", strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="REV_ABRANGENCIA", length=8000)
	private String abrangencia;
	
	@Column(name="REV_MOTIVO", length=8000)
	private String motivo;
	
	@Column(name="REV_CONTRIBUICAO", length=8000)
	private String contribuicao;
	
	@ManyToOne 
	@JoinColumn(name="REV_CEVID")
	private ConjuntoEvidenciasEntity conjuntoEvidencias;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="EPR_REVID")
	private List<EvidenciaProfissionalEntity> profissionais = new ArrayList<EvidenciaProfissionalEntity>();
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="EVI_REVID")
	private List<EvidenciaEntity> evidencias = new ArrayList<EvidenciaEntity>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAbrangencia() {
		return abrangencia;
	}

	public void setAbrangencia(String abrangencia) {
		this.abrangencia = abrangencia;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getContribuicao() {
		return contribuicao;
	}

	public void setContribuicao(String contribuicao) {
		this.contribuicao = contribuicao;
	}

	public ConjuntoEvidenciasEntity getConjuntoEvidencias() {
		return conjuntoEvidencias;
	}

	public void setConjuntoEvidencias(ConjuntoEvidenciasEntity conjuntoEvidencias) {
		this.conjuntoEvidencias = conjuntoEvidencias;
	}

	public List<EvidenciaProfissionalEntity> getProfissionais() {
		return profissionais;
	}

	public void setProfissionais(List<EvidenciaProfissionalEntity> profissionais) {
		this.profissionais = profissionais;
	}

	public List<EvidenciaEntity> getEvidencias() {
		return evidencias;
	}

	public void setEvidencias(List<EvidenciaEntity> evidencias) {
		this.evidencias = evidencias;
	}
	
}
