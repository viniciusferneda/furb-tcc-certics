package vinicius.ferneda.tcc.certics.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import vinicius.ferneda.tcc.certics.constant.EnumVersaoCertics;

@MappedSuperclass
public abstract class ResultadoEsperado implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="RES_ID", nullable=false)
	@GeneratedValue(generator="RES_ID", strategy=GenerationType.AUTO)
	private Long id;

	@Column(name="ARC_TITULO", nullable=false, length=255)
	private String titulo;
	
	@Column(name="ARC_DESCRICAO", nullable=false, length=8000)
	private String descricao;
	
	@ManyToOne 
	@JoinColumn(name="REV_ARCID", nullable=false)
	private AreaCompetenciaEntity areaCompetencia;

	@Column(name="REV_VERSAO_CERTICS", nullable=false, length=10)
	@Enumerated(EnumType.STRING)
	private EnumVersaoCertics versaoCertics;

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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public AreaCompetenciaEntity getAreaCompetencia() {
		return areaCompetencia;
	}

	public void setAreaCompetencia(AreaCompetenciaEntity areaCompetencia) {
		this.areaCompetencia = areaCompetencia;
	}

	public EnumVersaoCertics getVersaoCertics() {
		return versaoCertics;
	}

	public void setVersaoCertics(EnumVersaoCertics versaoCertics) {
		this.versaoCertics = versaoCertics;
	}
	
}
