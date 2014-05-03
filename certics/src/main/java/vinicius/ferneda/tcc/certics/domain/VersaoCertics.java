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
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

@MappedSuperclass
public class VersaoCertics implements Serializable{

private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "VCE_ID", nullable=false)
	@GeneratedValue(generator="VCE_ID", strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name="VCE_NOME", length=255)
	private String nome;
	
	@Column(name="VCE_DESCRICAO", length=8000)
	private String descricao;

	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="VAC_VCEID")
	private List<VersaoCerticsAreaCompetenciaEntity> lVersaoCerticsAreaCompetencia = new ArrayList<VersaoCerticsAreaCompetenciaEntity>();

	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="VRE_VCEID")
	private List<VersaoCerticsResultadoEsperadoEntity> lVersaoCerticsResultadoEsperado = new ArrayList<VersaoCerticsResultadoEsperadoEntity>();

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

	public List<VersaoCerticsAreaCompetenciaEntity> getlVersaoCerticsAreaCompetencia() {
		return lVersaoCerticsAreaCompetencia;
	}

	public void setlVersaoCerticsAreaCompetencia(List<VersaoCerticsAreaCompetenciaEntity> lVersaoCerticsAreaCompetencia) {
		this.lVersaoCerticsAreaCompetencia = lVersaoCerticsAreaCompetencia;
	}

	public List<VersaoCerticsResultadoEsperadoEntity> getlVersaoCerticsResultadoEsperado() {
		return lVersaoCerticsResultadoEsperado;
	}

	public void setlVersaoCerticsResultadoEsperado(List<VersaoCerticsResultadoEsperadoEntity> lVersaoCerticsResultadoEsperado) {
		this.lVersaoCerticsResultadoEsperado = lVersaoCerticsResultadoEsperado;
	}
	
}
