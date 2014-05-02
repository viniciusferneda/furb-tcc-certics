package vinicius.ferneda.tcc.certics.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import vinicius.ferneda.tcc.certics.constant.EnumPontuacaoAvaliacao;
import vinicius.ferneda.tcc.certics.constant.EnumVersaoCertics;

@Entity
@Table(name="TB_AVALIACAO")
@SequenceGenerator(name="AVA_ID", sequenceName="AVA_ID", allocationSize=1)
@NamedQueries({
    @NamedQuery(name = "AvaliacaoEntity.findById", query = "SELECT obj FROM AvaliacaoEntity obj WHERE obj.id = :id")
})
public class AvaliacaoEntity extends Avaliacao {

	private static final long serialVersionUID = 1L;

	public AvaliacaoEntity(){
	}
	
	public AvaliacaoEntity(EnumVersaoCertics versaoCertics, EnumPontuacaoAvaliacao pontuacao, Date dataAvaliacao, SoftwareEntity software, AvaliadorEntity avaliador) {
		setVersaoCertics(versaoCertics);
		setPontuacao(pontuacao);
		setDataAvaliacao(dataAvaliacao);
		setSoftware(software);
		setAvaliador(avaliador);
	}
	
	@Transient
	private ConjuntoEvidenciasEntity conjuntoEvidenciasAux;
	
	@Transient
	private RespostaEvidenciaEntity respostaEvidenciaAux;
	
	@Transient
	private EvidenciaEntity evidenciaAux;

	public ConjuntoEvidenciasEntity getConjuntoEvidenciasAux() {
		return conjuntoEvidenciasAux;
	}

	public void setConjuntoEvidenciasAux(ConjuntoEvidenciasEntity conjuntoEvidenciasAux) {
		this.conjuntoEvidenciasAux = conjuntoEvidenciasAux;
	}

	public RespostaEvidenciaEntity getRespostaEvidenciaAux() {
		return respostaEvidenciaAux;
	}

	public void setRespostaEvidenciaAux(RespostaEvidenciaEntity respostaEvidenciaAux) {
		this.respostaEvidenciaAux = respostaEvidenciaAux;
	}

	public EvidenciaEntity getEvidenciaAux() {
		return evidenciaAux;
	}

	public void setEvidenciaAux(EvidenciaEntity evidenciaAux) {
		this.evidenciaAux = evidenciaAux;
	}

}
