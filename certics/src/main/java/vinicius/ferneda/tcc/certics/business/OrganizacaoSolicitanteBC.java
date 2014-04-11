
package vinicius.ferneda.tcc.certics.business;

import vinicius.ferneda.tcc.certics.domain.OrganizacaoSolicitanteEntity;
import vinicius.ferneda.tcc.certics.persistence.OrganizacaoSolicitanteDAO;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

@BusinessController
public class OrganizacaoSolicitanteBC extends DelegateCrud<OrganizacaoSolicitanteEntity, Long, OrganizacaoSolicitanteDAO> {
	
	private static final long serialVersionUID = 1L;
	
}
