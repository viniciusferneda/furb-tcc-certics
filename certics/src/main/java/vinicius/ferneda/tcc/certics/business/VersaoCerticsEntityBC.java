package vinicius.ferneda.tcc.certics.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

import vinicius.ferneda.tcc.certics.domain.VersaoCerticsEntity;
import vinicius.ferneda.tcc.certics.persistence.VersaoCerticsEntityDAO;

@BusinessController
public class VersaoCerticsEntityBC extends DelegateCrud<VersaoCerticsEntity, Long, VersaoCerticsEntityDAO> {
	
	private static final long serialVersionUID = 1L;
	
}
