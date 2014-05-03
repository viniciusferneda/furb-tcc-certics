package vinicius.ferneda.tcc.certics.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

import vinicius.ferneda.tcc.certics.domain.VersaoCerticsAreaCompetenciaEntity;
import vinicius.ferneda.tcc.certics.persistence.VersaoCerticsAreaCompetenciaEntityDAO;

@BusinessController
public class VersaoCerticsAreaCompetenciaEntityBC extends DelegateCrud<VersaoCerticsAreaCompetenciaEntity, Long, VersaoCerticsAreaCompetenciaEntityDAO> {
	
	private static final long serialVersionUID = 1L;
	
}
