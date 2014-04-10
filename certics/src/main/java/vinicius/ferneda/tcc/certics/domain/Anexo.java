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
public abstract class Anexo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ANE_ID", nullable=false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name="ANE_ARQUIVO", nullable=false)
	private Byte arquivo;
	
	@ManyToOne 
	@JoinColumn(name="ANE_EVIID", nullable=false)
	private EvidenciaEntity evidencia;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Byte getArquivo() {
		return arquivo;
	}

	public void setArquivo(Byte arquivo) {
		this.arquivo = arquivo;
	}

	public EvidenciaEntity getEvidencia() {
		return evidencia;
	}

	public void setEvidencia(EvidenciaEntity evidencia) {
		this.evidencia = evidencia;
	}
	
}
