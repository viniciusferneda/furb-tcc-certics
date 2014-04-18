package vinicius.ferneda.tcc.certics.domain;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_RESPOSTA_EVIDENCIA")
@SequenceGenerator(name="REV_ID", sequenceName="REV_ID", allocationSize=1)
@NamedQueries({
    @NamedQuery(name="RespostaEvidenciaEntity.findById", query="SELECT obj FROM RespostaEvidenciaEntity obj WHERE obj.id = :id")
})
public class RespostaEvidenciaEntity extends RespostaEvidencia {

	private static final long serialVersionUID = 1L;
	
	public RespostaEvidenciaEntity(){
	}
	
	public RespostaEvidenciaEntity(String abrangencia, String motivo, String contribuicao, ConjuntoEvidenciasEntity conjuntoEvidencias) {
		setAbrangencia(abrangencia);
		setMotivo(motivo);
		setContribuicao(contribuicao);
		setConjuntoEvidencias(conjuntoEvidencias);
	}
	
}
