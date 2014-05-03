package vinicius.ferneda.tcc.certics.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

import vinicius.ferneda.tcc.certics.domain.VersaoCerticsResultadoEsperadoEntity;
import vinicius.ferneda.tcc.certics.persistence.VersaoCerticsResultadoEsperadoEntityDAO;

@BusinessController
public class VersaoCerticsResultadoEsperadoEntityBC extends DelegateCrud<VersaoCerticsResultadoEsperadoEntity, Long, VersaoCerticsResultadoEsperadoEntityDAO> {
	
	private static final long serialVersionUID = 1L;
	
}
