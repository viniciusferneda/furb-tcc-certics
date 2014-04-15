
package vinicius.ferneda.tcc.certics.business;

import vinicius.ferneda.tcc.certics.domain.UsuarioEntity;
import vinicius.ferneda.tcc.certics.persistence.UsuarioDAO;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

@BusinessController
public class UsuarioBC extends DelegateCrud<UsuarioEntity, Long, UsuarioDAO> {
	
	private static final long serialVersionUID = 1L;
	
}
