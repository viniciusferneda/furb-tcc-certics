
package vinicius.ferneda.tcc.certics.business;

import vinicius.ferneda.tcc.certics.domain.Anexo;
import vinicius.ferneda.tcc.certics.persistence.AnexoDAO;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

@BusinessController
public class AnexoBC extends DelegateCrud<Anexo, Long, AnexoDAO> {
	private static final long serialVersionUID = 1L;
	
	
}
