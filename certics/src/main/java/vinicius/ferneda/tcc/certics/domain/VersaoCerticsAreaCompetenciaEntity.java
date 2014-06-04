package vinicius.ferneda.tcc.certics.domain;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_VERSAO_CERTICS_AREA_COMPETENCIA")
@SequenceGenerator(name="VAC_ID", sequenceName="SEQ_VAC_ID", allocationSize=1)
@NamedQueries({
    @NamedQuery(name="VersaoCerticsAreaCompetenciaEntity.findById", 
    		query="SELECT obj "
    				+ " FROM VersaoCerticsAreaCompetenciaEntity obj "
    				+ " WHERE obj.id = :id"),
    				
    @NamedQuery(name="VersaoCerticsAreaCompetenciaEntity.possuiVersaoCertics", 
    		query="SELECT count(obj.id) "
    				+ " FROM VersaoCerticsAreaCompetenciaEntity obj "
    				+ " WHERE obj.versaoCertics.id = :versaoID "
    				+ "		AND obj.areaCompetencia.id = :areaCompetenciaID"),
    				
	@NamedQuery(name="VersaoCerticsAreaCompetenciaEntity.findByVersaoCerticsID", 
    		query="SELECT obj.id "
    				+ " FROM VersaoCerticsAreaCompetenciaEntity obj "
    				+ " WHERE obj.versaoCertics.id = :versaoCerticsID"
    				+ "		AND obj.areaCompetencia.id = :areaCompetenciaID")
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
