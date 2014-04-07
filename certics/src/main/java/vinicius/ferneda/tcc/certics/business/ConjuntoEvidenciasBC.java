
package vinicius.ferneda.tcc.certics.business;

import vinicius.ferneda.tcc.certics.domain.ConjuntoEvidencias;
import vinicius.ferneda.tcc.certics.persistence.ConjuntoEvidenciasDAO;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

@BusinessController
public class ConjuntoEvidenciasBC extends DelegateCrud<ConjuntoEvidencias, Long, ConjuntoEvidenciasDAO> {
	private static final long serialVersionUID = 1L;
	
	
}
