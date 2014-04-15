package vinicius.ferneda.tcc.certics.persistence;

import vinicius.ferneda.tcc.certics.domain.EnderecoEntity;
import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

@PersistenceController
public class EnderecoDAO extends JPACrud<EnderecoEntity, Long> {

	private static final long serialVersionUID = 1L;
	
}
