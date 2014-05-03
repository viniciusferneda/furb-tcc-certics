
package vinicius.ferneda.tcc.certics.business;

import vinicius.ferneda.tcc.certics.domain.ResultadoEsperadoEntity;
import vinicius.ferneda.tcc.certics.persistence.ResultadoEsperadoDAO;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

@BusinessController
public class ResultadoEsperadoBC extends DelegateCrud<ResultadoEsperadoEntity, Long, ResultadoEsperadoDAO> {
	
	private static final long serialVersionUID = 1L;
	
}
