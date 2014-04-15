package vinicius.ferneda.tcc.certics.domain;

import java.io.Serializable;
import java.util.ArrayList;
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
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

import vinicius.ferneda.tcc.certics.constant.EnumVersaoCertics;

@MappedSuperclass
public abstract class AreaCompetencia implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ARC_ID", nullable=false)
	@GeneratedValue(generator="ARC_ID", strategy = GenerationType.AUTO)
	private Long id;

	@Column(name="ARC_TITULO", nullable=false, length=255)
	private String titulo;
	
	@Column(name="ARC_PERGUNTA_CHAVE", nullable=false, length=255)
	private String perguntaChave;
	
	@Column(name="ARC_DESCRICAO", nullable=false, length=8000)
	private String descricao;
	
	@Column(name="ARC_VERSAO_CERTICS", nullable=false, length=10)
	@Enumerated(EnumType.STRING)
	private EnumVersaoCertics versaoCertics;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="REV_ARCID")
	private List<ResultadoEsperadoEntity> resultadosEsperados = new ArrayList<ResultadoEsperadoEntity>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getPerguntaChave() {
		return perguntaChave;
	}

	public void setPerguntaChave(String perguntaChave) {
		this.perguntaChave = perguntaChave;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public EnumVersaoCertics getVersaoCertics() {
		return versaoCertics;
	}

	public void setVersaoCertics(EnumVersaoCertics versaoCertics) {
		this.versaoCertics = versaoCertics;
	}

	public List<ResultadoEsperadoEntity> getResultadosEsperados() {
		return resultadosEsperados;
	}

	public void setResultadosEsperados(List<ResultadoEsperadoEntity> resultadosEsperados) {
		this.resultadosEsperados = resultadosEsperados;
	}
	
}
