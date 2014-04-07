package vinicius.ferneda.tcc.certics.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="TB_LICAO_APRENDIDA")
public class LicaoAprendida implements Serializable{

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
	private Avaliacao avaliacao;

	public LicaoAprendida(){
	}
	
	public LicaoAprendida(String pontosPositivos, String pontosNegativos, String melhoria, Avaliacao avaliacao) {
		this.pontosPositivos = pontosPositivos;
		this.pontosNegativos = pontosNegativos;
		this.melhoria = melhoria;
		this.avaliacao = avaliacao;
	}

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

	public Avaliacao getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}
	
}
