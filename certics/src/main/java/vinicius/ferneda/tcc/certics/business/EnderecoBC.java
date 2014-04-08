
package vinicius.ferneda.tcc.certics.business;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import vinicius.ferneda.tcc.certics.constant.EnumUF;
import vinicius.ferneda.tcc.certics.domain.Endereco;
import vinicius.ferneda.tcc.certics.persistence.EnderecoDAO;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

@BusinessController
public class EnderecoBC extends DelegateCrud<Endereco, Long, EnderecoDAO> {
	private static final long serialVersionUID = 1L;
	
	public List<SelectItem> getEnumUF() {
		List<SelectItem> varEnumUF = new ArrayList<SelectItem>();
		for (EnumUF eachEnumUF : EnumUF.values()) {
			varEnumUF.add(new SelectItem(eachEnumUF.getNome()));
		}
		return varEnumUF;
	}
	
}
