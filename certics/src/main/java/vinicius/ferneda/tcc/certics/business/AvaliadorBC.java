
package vinicius.ferneda.tcc.certics.business;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import vinicius.ferneda.tcc.certics.constant.EnumSexo;
import vinicius.ferneda.tcc.certics.domain.Avaliador;
import vinicius.ferneda.tcc.certics.persistence.AvaliadorDAO;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

// To remove unused imports press: Ctrl+Shift+o

@BusinessController
public class AvaliadorBC extends DelegateCrud<Avaliador, Long, AvaliadorDAO> {
	private static final long serialVersionUID = 1L;
	
	
	public List<SelectItem> getEnumSexo() {
		List<SelectItem> varEnumSexo = new ArrayList<SelectItem>();
		for (EnumSexo eachEnumSexo : EnumSexo.values()) {
			varEnumSexo.add(new SelectItem(eachEnumSexo));
		}
		return varEnumSexo;
	}
	
}
