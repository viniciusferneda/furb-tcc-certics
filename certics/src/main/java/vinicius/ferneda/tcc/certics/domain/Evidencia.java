package vinicius.ferneda.tcc.certics.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="TB_EVIDENCIA")
public class Evidencia implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="EVI_ID", nullable=false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@Column(name="EVI_NOME", nullable=false, length=255)
	private String nome;
	
	@Column(name="EVI_DESCRICAO", nullable=false, length=8000)
	private String descricao;
	
	@ManyToOne 
	@JoinColumn(name="EVI_REVID", nullable=false)
	private RespostaEvidencia respostaEvidencia;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="ANE_EVIID")
	private List<Anexo> anexos = new ArrayList<Anexo>();

	public Evidencia(){
	}
	
	public Evidencia(String nome, String descricao, RespostaEvidencia respostaEvidencia) {
		this.nome = nome;
		this.descricao = descricao;
		this.respostaEvidencia = respostaEvidencia;
	}

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

	public RespostaEvidencia getRespostaEvidencia() {
		return respostaEvidencia;
	}

	public void setRespostaEvidencia(RespostaEvidencia respostaEvidencia) {
		this.respostaEvidencia = respostaEvidencia;
	}

	public List<Anexo> getAnexos() {
		return anexos;
	}

	public void setAnexos(List<Anexo> anexos) {
		this.anexos = anexos;
	}
	
}
