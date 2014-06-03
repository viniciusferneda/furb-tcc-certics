package vinicius.ferneda.tcc.certics.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
public abstract class ResultadoEsperado implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="RES_ID", nullable=false)
	@GeneratedValue(generator="RES_ID", strategy=GenerationType.AUTO)
	private Long id;

	@Column(name="RES_TITULO", nullable=false, length=255)
	private String titulo;
	
	@Column(name="RES_DESCRICAO", nullable=false, length=8000)
	private String descricao;
	
	@Column(name="RES_DICA", nullable=false, length=8000)
	private String dica;
	
	@ManyToOne(fetch=FetchType.LAZY) 
	@JoinColumn(name="RES_ARCID", nullable=false)
	private AreaCompetenciaEntity areaCompetencia;
	
	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="CEV_RESID")
	private List<ConjuntoEvidenciasEntity> conjuntoEvidencias = new ArrayList<ConjuntoEvidenciasEntity>();
	
	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="VRE_RESID")
	private List<VersaoCerticsResultadoEsperadoEntity> lVersaoCerticsResultadoEsperado = new ArrayList<VersaoCerticsResultadoEsperadoEntity>();

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
	
	public String getDica() {
		return dica;
	}

	public void setDica(String dica) {
		this.dica = dica;
	}

	public AreaCompetenciaEntity getAreaCompetencia() {
		return areaCompetencia;
	}

	public void setAreaCompetencia(AreaCompetenciaEntity areaCompetencia) {
		this.areaCompetencia = areaCompetencia;
	}

	public List<ConjuntoEvidenciasEntity> getConjuntoEvidencias() {
		return conjuntoEvidencias;
	}

	public void setConjuntoEvidencias(List<ConjuntoEvidenciasEntity> conjuntoEvidencias) {
		this.conjuntoEvidencias = conjuntoEvidencias;
	}

	public List<VersaoCerticsResultadoEsperadoEntity> getlVersaoCerticsResultadoEsperado() {
		return lVersaoCerticsResultadoEsperado;
	}

	public void setlVersaoCerticsResultadoEsperado(List<VersaoCerticsResultadoEsperadoEntity> lVersaoCerticsResultadoEsperado) {
		this.lVersaoCerticsResultadoEsperado = lVersaoCerticsResultadoEsperado;
	}
	
}
