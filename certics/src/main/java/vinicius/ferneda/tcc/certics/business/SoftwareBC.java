
package vinicius.ferneda.tcc.certics.business;

import vinicius.ferneda.tcc.certics.domain.Software;
import vinicius.ferneda.tcc.certics.persistence.SoftwareDAO;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

@BusinessController
public class SoftwareBC extends DelegateCrud<Software, Long, SoftwareDAO> {
	private static final long serialVersionUID = 1L;
	
	
}
