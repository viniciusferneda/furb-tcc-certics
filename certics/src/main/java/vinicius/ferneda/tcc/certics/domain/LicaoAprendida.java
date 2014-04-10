package vinicius.ferneda.tcc.certics.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class LicaoAprendida implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="LIA_ID", nullable=false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	
	@Column(name="LIA_PONTOS_POSITIVOS", nullable=false, length=8000)
	private String pontosPositivos;
	
	@Column(name="LIA_PONTOS_NEGATIVOS", nullable=false, length=8000)
	private String pontosNegativos;
	
	@Column(name="LIA_MELHORIA", length=8000)
	private String melhoria;
	
	@ManyToOne 
	@JoinColumn(name="LIA_AVAID", nullable=false)
	private AvaliacaoEntity avaliacao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPontosPositivos() {
		return pontosPositivos;
	}

	public void setPontosPositivos(String pontosPositivos) {
		this.pontosPositivos = pontosPositivos;
	}

	public String getPontosNegativos() {
		return pontosNegativos;
	}

	public void setPontosNegativos(String pontosNegativos) {
		this.pontosNegativos = pontosNegativos;
	}

	public String getMelhoria() {
		return melhoria;
	}

	public void setMelhoria(String melhoria) {
		this.melhoria = melhoria;
	}

	public AvaliacaoEntity getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(AvaliacaoEntity avaliacao) {
		this.avaliacao = avaliacao;
	}
	
}
