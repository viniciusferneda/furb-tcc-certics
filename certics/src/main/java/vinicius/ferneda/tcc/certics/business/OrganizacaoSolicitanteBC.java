
package vinicius.ferneda.tcc.certics.business;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import vinicius.ferneda.tcc.certics.constant.EnumUF;
import vinicius.ferneda.tcc.certics.domain.OrganizacaoSolicitanteEntity;
import vinicius.ferneda.tcc.certics.persistence.OrganizacaoSolicitanteDAO;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

@BusinessController
public class OrganizacaoSolicitanteBC extends DelegateCrud<OrganizacaoSolicitanteEntity, Long, OrganizacaoSolicitanteDAO> {
	
	private static final long serialVersionUID = 1L;
	
	public List<SelectItem> getEnumUF() {
		List<SelectItem> varEnumUF = new ArrayList<SelectItem>();
		for (EnumUF eachEnumUF : EnumUF.values()) {
			varEnumUF.add(new SelectItem(eachEnumUF, eachEnumUF.getNome()));
		}
		return varEnumUF;
	}
	
}
