package vinicius.ferneda.tcc.certics.domain;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_VERSAO_CERTICS_RESULTADO_ESPERADO")
@SequenceGenerator(name="VRE_ID", sequenceName="VRE_ID", allocationSize=1)
@NamedQueries({
    @NamedQuery(name="VersaoCerticsResultadoEsperadoEntity.findById", 
    		query="SELECT obj "
    				+ " FROM VersaoCerticsResultadoEsperadoEntity obj "
    				+ " WHERE obj.id = :id")
})
public class VersaoCerticsResultadoEsperadoEntity extends VersaoCerticsResultadoEsperado {

	private static final long serialVersionUID = 1L;
	
	public VersaoCerticsResultadoEsperadoEntity(){
	}
	
	public VersaoCerticsResultadoEsperadoEntity(ResultadoEsperadoEntity resultadoEsperado, VersaoCerticsEntity versaoCertics){
		setResultadoEsperado(resultadoEsperado);
		setVersaoCertics(versaoCertics);
	}
}
