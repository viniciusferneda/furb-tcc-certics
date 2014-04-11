package vinicius.ferneda.tcc.certics.persistence;

import vinicius.ferneda.tcc.certics.domain.UsuarioEntity;
import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

@PersistenceController
public class UsuarioDAO extends JPACrud<UsuarioEntity, Long> {

	private static final long serialVersionUID = 1L;
	
}
