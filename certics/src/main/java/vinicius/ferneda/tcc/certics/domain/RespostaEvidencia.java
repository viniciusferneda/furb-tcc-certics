package vinicius.ferneda.tcc.certics.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import vinicius.ferneda.tcc.certics.constant.EnumPontuacaoEvidencia;

@Entity
@Table(name="TB_RESPOSTA_EVIDENCIA")
public class RespostaEvidencia implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="REV_ID", nullable=false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name="REV_PONTUACAO", nullable=false)
	@Enumerated(EnumType.STRING)
	private EnumPontuacaoEvidencia pontuacao;
	
	@Column(name="REV_ABRANGENCIA", length=8000)
	private String abrangencia;
	
	@Column(name="REV_MOTIVO", length=8000)
	private String motivo;
	
	@Column(name="REV_CONTRIBUICAO", length=8000)
	private String contribuicao;
	
	@ManyToOne 
	@JoinColumn(name="REV_AVAID", nullable=false)
	private Avaliacao avaliacao;
	
	@ManyToOne 
	@JoinColumn(name="REV_CEVID", nullable=false)
	private ConjuntoEvidencias conjuntoEvidencias;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="EPR_REVID")
	private List<EvidenciaProfissional> profissionais = new ArrayList<EvidenciaProfissional>();
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="EVI_REVID")
	private List<Evidencia> evidencias = new ArrayList<Evidencia>();

	public RespostaEvidencia(){
	}
	
	public RespostaEvidencia(EnumPontuacaoEvidencia pontuacao, String abrangencia, String motivo, String contribuicao, Avaliacao avaliacao, ConjuntoEvidencias conjuntoEvidencias) {
		this.pontuacao = pontuacao;
		this.abrangencia = abrangencia;
		this.motivo = motivo;
		this.contribuicao = contribuicao;
		this.avaliacao = avaliacao;
		this.conjuntoEvidencias = conjuntoEvidencias;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EnumPontuacaoEvidencia getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(EnumPontuacaoEvidencia pontuacao) {
		this.pontuacao = pontuacao;
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

	public Avaliacao getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}
	
	public ConjuntoEvidencias getConjuntoEvidencias() {
		return conjuntoEvidencias;
	}

	public void setConjuntoEvidencias(ConjuntoEvidencias conjuntoEvidencias) {
		this.conjuntoEvidencias = conjuntoEvidencias;
	}

	public List<EvidenciaProfissional> getProfissionais() {
		return profissionais;
	}

	public void setProfissionais(List<EvidenciaProfissional> profissionais) {
		this.profissionais = profissionais;
	}

	public List<Evidencia> getEvidencias() {
		return evidencias;
	}

	public void setEvidencias(List<Evidencia> evidencias) {
		this.evidencias = evidencias;
	}
	
}
