
package vinicius.ferneda.tcc.certics.business;

import vinicius.ferneda.tcc.certics.domain.AnexoEntity;
import vinicius.ferneda.tcc.certics.persistence.AnexoDAO;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

@BusinessController
public class AnexoBC extends DelegateCrud<AnexoEntity, Long, AnexoDAO> {
	private static final long serialVersionUID = 1L;
	
	
}
