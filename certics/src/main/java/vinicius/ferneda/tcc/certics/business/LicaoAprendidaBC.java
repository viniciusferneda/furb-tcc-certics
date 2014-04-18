
package vinicius.ferneda.tcc.certics.business;

import vinicius.ferneda.tcc.certics.domain.LicaoAprendidaEntity;
import vinicius.ferneda.tcc.certics.persistence.LicaoAprendidaDAO;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

@BusinessController
public class LicaoAprendidaBC extends DelegateCrud<LicaoAprendidaEntity, Long, LicaoAprendidaDAO> {
	
	private static final long serialVersionUID = 1L;
	
}
