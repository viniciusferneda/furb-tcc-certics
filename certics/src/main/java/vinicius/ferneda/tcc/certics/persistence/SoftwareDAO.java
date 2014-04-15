package vinicius.ferneda.tcc.certics.persistence;

import vinicius.ferneda.tcc.certics.domain.SoftwareEntity;
import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

@PersistenceController
public class SoftwareDAO extends JPACrud<SoftwareEntity, Long> {

	private static final long serialVersionUID = 1L;
	

}
