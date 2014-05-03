package vinicius.ferneda.tcc.certics.domain;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_VERSAO_CERTICS_AREA_COMPETENCIA")
@SequenceGenerator(name="VAC_ID", sequenceName="VAC_ID", allocationSize=1)
@NamedQueries({
    @NamedQuery(name="VersaoCerticsAreaCompetenciaEntity.findById", 
    		query="SELECT obj "
    				+ " FROM VersaoCerticsAreaCompetenciaEntity obj "
    				+ " WHERE obj.id = :id")
})
public class VersaoCerticsAreaCompetenciaEntity extends VersaoCerticsAreaCompetencia {

	private static final long serialVersionUID = 1L;
	
	public VersaoCerticsAreaCompetenciaEntity(){
	}
	
	public VersaoCerticsAreaCompetenciaEntity(AreaCompetenciaEntity areaCompetencia, VersaoCerticsEntity versaoCertics){
		setAreaCompetencia(areaCompetencia);
		setVersaoCertics(versaoCertics);
	}
}
