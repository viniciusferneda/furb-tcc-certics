
package vinicius.ferneda.tcc.certics.business;

import java.util.List;

import javax.inject.Inject;

import vinicius.ferneda.tcc.certics.domain.ResultadoEsperadoEntity;
import vinicius.ferneda.tcc.certics.persistence.ResultadoEsperadoDAO;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

@BusinessController
public class ResultadoEsperadoBC extends DelegateCrud<ResultadoEsperadoEntity, Long, ResultadoEsperadoDAO> {
	
	private static final long serialVersionUID = 1L;

	@Inject
    private ResultadoEsperadoDAO resultadoEsperadoDAO;
	
	public boolean possuiResultadoEsperadoVersao(Long versaoCerticsID){
		List<ResultadoEsperadoEntity> lResultados = resultadoEsperadoDAO.findByVersaoCertics(versaoCerticsID);
		if(lResultados == null || lResultados.isEmpty()){
			return false;
		}else{
			return true;
		}
	}
}
