package vinicius.ferneda.tcc.certics.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class VersaoCerticsResultadoEsperado implements Serializable{

private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="VRE_ID", nullable=false)
	@GeneratedValue(generator="VRE_ID", strategy=GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(fetch=FetchType.LAZY) 
	@JoinColumn(name="VRE_RESID", nullable=false)
	private ResultadoEsperadoEntity resultadoEsperado;
	
	@ManyToOne(fetch=FetchType.LAZY) 
	@JoinColumn(name="VRE_VCEID", nullable=false)
	private VersaoCerticsEntity versaoCertics;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ResultadoEsperadoEntity getResultadoEsperado() {
		return resultadoEsperado;
	}

	public void setResultadoEsperado(ResultadoEsperadoEntity resultadoEsperado) {
		this.resultadoEsperado = resultadoEsperado;
	}

	public VersaoCerticsEntity getVersaoCertics() {
		return versaoCertics;
	}

	public void setVersaoCertics(VersaoCerticsEntity versaoCertics) {
		this.versaoCertics = versaoCertics;
	}
	
}
