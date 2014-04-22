package vinicius.ferneda.tcc.certics.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import vinicius.ferneda.tcc.certics.constant.EnumPontuacaoAvaliacao;
import vinicius.ferneda.tcc.certics.constant.EnumVersaoCertics;

@MappedSuperclass
public abstract class Avaliacao implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="AVA_ID", nullable=false)
	@GeneratedValue(generator="AVA_ID", strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="AVA_VERSAO_CERTICS", nullable=false, length=10)
	@Enumerated(EnumType.STRING)
	private EnumVersaoCertics versaoCertics;
	
	@Column(name="AVA_PONTUACAO", nullable=false, length=10)
	@Enumerated(EnumType.STRING)
	private EnumPontuacaoAvaliacao pontuacao;
	
	@Column(name="AVA_DT_AVALIACAO", nullable=false)
	@Temporal(value=TemporalType.DATE)
	private Date dataAvaliacao;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="AVA_SOFID", nullable=false)
	private SoftwareEntity software;
	
	@ManyToOne
	@JoinColumn(name="AVA_AVRID", nullable=false)
	private AvaliadorEntity avaliador;

	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="LIA_AVAID")
	private List<LicaoAprendidaEntity> licoesAprendidas = new ArrayList<LicaoAprendidaEntity>();
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="CEV_AVAID")
	private List<ConjuntoEvidenciasEntity> respostas = new ArrayList<ConjuntoEvidenciasEntity>();
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public EnumVersaoCertics getVersaoCertics() {
		return versaoCertics;
	}

	public void setVersaoCertics(EnumVersaoCertics versaoCertics) {
		this.versaoCertics = versaoCertics;
	}

	public EnumPontuacaoAvaliacao getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(EnumPontuacaoAvaliacao pontuacao) {
		this.pontuacao = pontuacao;
	}

	public Date getDataAvaliacao() {
		return dataAvaliacao;
	}

	public void setDataAvaliacao(Date dataAvaliacao) {
		this.dataAvaliacao = dataAvaliacao;
	}

	public SoftwareEntity getSoftware() {
		return software;
	}

	public void setSoftware(SoftwareEntity software) {
		this.software = software;
	}

	public AvaliadorEntity getAvaliador() {
		return avaliador;
	}

	public void setAvaliador(AvaliadorEntity avaliador) {
		this.avaliador = avaliador;
	}

	public List<LicaoAprendidaEntity> getLicoesAprendidas() {
		return licoesAprendidas;
	}

	public void setLicoesAprendidas(List<LicaoAprendidaEntity> licoesAprendidas) {
		this.licoesAprendidas = licoesAprendidas;
	}

	public List<ConjuntoEvidenciasEntity> getRespostas() {
		return respostas;
	}

	public void setRespostas(List<ConjuntoEvidenciasEntity> respostas) {
		this.respostas = respostas;
	}
	
}
