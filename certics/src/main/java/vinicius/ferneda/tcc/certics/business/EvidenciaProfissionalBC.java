
package vinicius.ferneda.tcc.certics.business;

import vinicius.ferneda.tcc.certics.domain.EvidenciaProfissional;
import vinicius.ferneda.tcc.certics.persistence.EvidenciaProfissionalDAO;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

@BusinessController
public class EvidenciaProfissionalBC extends DelegateCrud<EvidenciaProfissional, Long, EvidenciaProfissionalDAO> {
	private static final long serialVersionUID = 1L;
	
	
}
