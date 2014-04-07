
package vinicius.ferneda.tcc.certics.business;

import vinicius.ferneda.tcc.certics.domain.Evidencia;
import vinicius.ferneda.tcc.certics.persistence.EvidenciaDAO;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

@BusinessController
public class EvidenciaBC extends DelegateCrud<Evidencia, Long, EvidenciaDAO> {
	private static final long serialVersionUID = 1L;
	
	
}
