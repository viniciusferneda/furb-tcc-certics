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
public abstract class Anexo implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="ANE_ID", nullable=false)
	@GeneratedValue(generator="ANE_ID", strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="ANE_NOME", nullable=false, length=255)
	private String nome;

	@Column(name="ANE_ARQUIVO", nullable=false)
	private byte[] arquivo;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ANE_EVIID", nullable=false)
	private EvidenciaEntity evidencia;

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

	public byte[] getArquivo() {
		return arquivo;
	}

	public void setArquivo(byte[] arquivo) {
		this.arquivo = arquivo;
	}

	public EvidenciaEntity getEvidencia() {
		return evidencia;
	}

	public void setEvidencia(EvidenciaEntity evidencia) {
		this.evidencia = evidencia;
	}
	
}
