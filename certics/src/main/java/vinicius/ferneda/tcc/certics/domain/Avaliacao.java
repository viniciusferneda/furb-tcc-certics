package vinicius.ferneda.tcc.certics.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import vinicius.ferneda.tcc.certics.constant.EnumPontuacaoAvaliacao;
import vinicius.ferneda.tcc.certics.constant.EnumVersaoCertics;

@Entity
@Table(name="TB_AVALIACAO")
public class Avaliacao implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="AVA_ID", nullable=false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
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
	
	@ManyToOne 
	@JoinColumn(name="AVA_SOFID", nullable=false)
	private Software software;
	
	@ManyToOne
	@JoinColumn(name="AVA_AVRID", nullable=false)
	private Avaliador avaliador;

	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="LIA_AVAID")
	private List<LicaoAprendida> licoesAprendidas = new ArrayList<LicaoAprendida>();
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="REV_AVAID")
	private List<RespostaEvidencia> respostas = new ArrayList<RespostaEvidencia>();
	
	public Avaliacao(){
	}
	
	public Avaliacao(EnumVersaoCertics versaoCertics, EnumPontuacaoAvaliacao pontuacao, Date dataAvaliacao, Software software, Avaliador avaliador) {
		this.versaoCertics = versaoCertics;
		this.pontuacao = pontuacao;
		this.dataAvaliacao = dataAvaliacao;
		this.software = software;
		this.avaliador = avaliador;
	}

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

	public Software getSoftware() {
		return software;
	}

	public void setSoftware(Software software) {
		this.software = software;
	}

	public Avaliador getAvaliador() {
		return avaliador;
	}

	public void setAvaliador(Avaliador avaliador) {
		this.avaliador = avaliador;
	}

	public List<LicaoAprendida> getLicoesAprendidas() {
		return licoesAprendidas;
	}

	public void setLicoesAprendidas(List<LicaoAprendida> licoesAprendidas) {
		this.licoesAprendidas = licoesAprendidas;
	}

	public List<RespostaEvidencia> getRespostas() {
		return respostas;
	}

	public void setRespostas(List<RespostaEvidencia> respostas) {
		this.respostas = respostas;
	}
}
