package vinicius.ferneda.tcc.certics.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class VersaoCerticsAreaCompetencia implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="VAC_ID", nullable=false)
	@GeneratedValue(generator="VAC_ID", strategy=GenerationType.AUTO)
	private Long id;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY) 
	@JoinColumn(name="VAC_ARCID", nullable=false)
	private AreaCompetenciaEntity areaCompetencia;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.LAZY) 
	@JoinColumn(name="VAC_VCEID", nullable=false)
	private VersaoCerticsEntity versaoCertics;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AreaCompetenciaEntity getAreaCompetencia() {
		return areaCompetencia;
	}

	public void setAreaCompetencia(AreaCompetenciaEntity areaCompetencia) {
		this.areaCompetencia = areaCompetencia;
	}

	public VersaoCerticsEntity getVersaoCertics() {
		return versaoCertics;
	}

	public void setVersaoCertics(VersaoCerticsEntity versaoCertics) {
		this.versaoCertics = versaoCertics;
	}
	
}
