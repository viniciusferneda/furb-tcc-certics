package vinicius.ferneda.tcc.certics.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public abstract class Software implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="SOF_ID", nullable=false)
	@GeneratedValue(generator="SOF_ID", strategy=GenerationType.AUTO)
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
	
	@ManyToOne 
	@JoinColumn(name="SOF_ORSID", nullable=false)
	private OrganizacaoSolicitanteEntity organizacaoSolicitante;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="AVA_SOFID")
	private List<AvaliacaoEntity> avaliacoes = new ArrayList<AvaliacaoEntity>();

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

	public OrganizacaoSolicitanteEntity getOrganizacaoSolicitante() {
		return organizacaoSolicitante;
	}

	public void setOrganizacaoSolicitante(OrganizacaoSolicitanteEntity organizacaoSolicitante) {
		this.organizacaoSolicitante = organizacaoSolicitante;
	}

	public List<AvaliacaoEntity> getAvaliacoes() {
		return avaliacoes;
	}

	public void setAvaliacoes(List<AvaliacaoEntity> avaliacoes) {
		this.avaliacoes = avaliacoes;
	}
	
}
