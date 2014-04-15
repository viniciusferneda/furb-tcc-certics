package vinicius.ferneda.tcc.certics.domain;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_EVIDENCIA_PROFISSIONAL")
@SequenceGenerator(name="EPR_ID", sequenceName="EPR_ID")
@NamedQueries({
    @NamedQuery(name="EvidenciaProfissionalEntity.findById", query="SELECT obj FROM EvidenciaProfissionalEntity obj WHERE obj.id = :id")
})
public class EvidenciaProfissionalEntity extends EvidenciaProfissional {

	private static final long serialVersionUID = 1L;
	
	public EvidenciaProfissionalEntity(){
	}
	
	public EvidenciaProfissionalEntity(Integer fazParteOrganizacao, String envolvimento, RespostaEvidenciaEntity respostaEvidencia, ProfissionalEntity profissional) {
		setFazParteOrganizacao(fazParteOrganizacao);
		setEnvolvimento(envolvimento);
		setRespostaEvidencia(respostaEvidencia);
		setProfissional(profissional);
	}
	
}
