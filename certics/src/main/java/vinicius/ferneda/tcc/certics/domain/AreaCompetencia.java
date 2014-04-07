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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import vinicius.ferneda.tcc.certics.constant.EnumVersaoCertics;

@Entity
@Table(name="TB_AREA_COMPETENCIA")
public class AreaCompetencia implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ARC_ID", nullable=false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
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
	private List<ResultadoEsperado> resultadosEsperados = new ArrayList<ResultadoEsperado>();

	public AreaCompetencia(){
	}
	
	public AreaCompetencia(String titulo, String perguntaChave, String descricao, EnumVersaoCertics versaoCertics) {
		this.titulo = titulo;
		this.perguntaChave = perguntaChave;
		this.descricao = descricao;
		this.versaoCertics = versaoCertics;
	}

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

	public List<ResultadoEsperado> getResultadosEsperados() {
		return resultadosEsperados;
	}

	public void setResultadosEsperados(List<ResultadoEsperado> resultadosEsperados) {
		this.resultadosEsperados = resultadosEsperados;
	}
	
}
