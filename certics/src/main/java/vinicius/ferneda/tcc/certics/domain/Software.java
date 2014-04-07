package vinicius.ferneda.tcc.certics.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TB_SOFTWARE")
public class Software implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="SOF_ID", nullable=false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name="SOF_NOME", nullable=false, length=255)
	private String nome;
	
	@Column(name="SOF_DESCRICAO", nullable=false, length=8000)
	private String descricao;
	
	@Column(name="SOF_HISTORICO", length=8000)
	private String historico;
	
	@Column(name="SOF_TECNOLOGIAS", length=8000)
	private String tecnologias;
	
	@Column(name="SOF_ASPECTO_INOVADOR", length=8000)
	private String aspectoInovador;
	
	@Column(name="SOF_VERSAO", length=10)
	private String release;
	
	@Column(name="SOF_DATA_INICIO")
	@Temporal(value=TemporalType.DATE)
	private Date dataInicio;

	@Column(name="SOF_DATA_LIBERACAO")
	@Temporal(value=TemporalType.DATE)
	private Date dataLiberacaoVersao;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="AVA_SOFID")
	private List<Avaliacao> avaliacoes = new ArrayList<Avaliacao>();

	public Software(){
	}
	
	public Software(String nome, String descricao, String historico, String tecnologias, String aspectoInovador, String release, Date dataInicio, Date dataLiberacaoVersao) {
		this.nome = nome;
		this.descricao = descricao;
		this.historico = historico;
		this.tecnologias = tecnologias;
		this.aspectoInovador = aspectoInovador;
		this.release = release;
		this.dataInicio = dataInicio;
		this.dataLiberacaoVersao = dataLiberacaoVersao;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getHistorico() {
		return historico;
	}

	public void setHistorico(String historico) {
		this.historico = historico;
	}

	public String getTecnologias() {
		return tecnologias;
	}

	public void setTecnologias(String tecnologias) {
		this.tecnologias = tecnologias;
	}

	public String getAspectoInovador() {
		return aspectoInovador;
	}

	public void setAspectoInovador(String aspectInovador) {
		this.aspectoInovador = aspectInovador;
	}

	public String getRelease() {
		return release;
	}

	public void setRelease(String release) {
		this.release = release;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataLiberacaoVersao() {
		return dataLiberacaoVersao;
	}

	public void setDataLiberacaoVersao(Date dataLiberacaoVersao) {
		this.dataLiberacaoVersao = dataLiberacaoVersao;
	}

	public List<Avaliacao> getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(List<Avaliacao> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}
	
}
