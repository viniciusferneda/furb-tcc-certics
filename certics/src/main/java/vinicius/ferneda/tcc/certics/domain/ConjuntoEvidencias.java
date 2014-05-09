package vinicius.ferneda.tcc.certics.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import vinicius.ferneda.tcc.certics.constant.EnumPontuacaoEvidencia;

@MappedSuperclass
public abstract class ConjuntoEvidencias implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="CEV_ID", nullable=false)
	@GeneratedValue(generator="CEV_ID", strategy = GenerationType.AUTO)
	private Long id;

	@Column(name="CEV_PONTUACAO")
	@Enumerated(EnumType.STRING)
	private EnumPontuacaoEvidencia pontuacao;

	@Column(name="CEV_COMENTARIO", length=8000)
	private String comentario;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CEV_AVAID", nullable=false)
	private AvaliacaoEntity avaliacao;
	
	@JoinColumn(name="CEV_RESID", nullable=false)
	@OneToOne(fetch=FetchType.LAZY)
	private ResultadoEsperadoEntity resultadoEsperado;
	
	@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="EVI_REVID")
	private List<RespostaEvidenciaEntity> respostas = new ArrayList<RespostaEvidenciaEntity>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public EnumPontuacaoEvidencia getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(EnumPontuacaoEvidencia pontuacao) {
		this.pontuacao = pontuacao;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public String getComentario() {
		return comentario;
	}
	
	public AvaliacaoEntity getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(AvaliacaoEntity avaliacao) {
		this.avaliacao = avaliacao;
	}

	public ResultadoEsperadoEntity getResultadoEsperado() {
		return resultadoEsperado;
	}

	public void setResultadoEsperado(ResultadoEsperadoEntity resultadoEsperado) {
		this.resultadoEsperado = resultadoEsperado;
	}

	public List<RespostaEvidenciaEntity> getRespostas() {
		return respostas;
	}

	public void setRespostas(List<RespostaEvidenciaEntity> respostas) {
		this.respostas = respostas;
	}
	
}
