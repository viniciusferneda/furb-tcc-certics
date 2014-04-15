
package vinicius.ferneda.tcc.certics.business;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import vinicius.ferneda.tcc.certics.constant.EnumVersaoCertics;
import vinicius.ferneda.tcc.certics.domain.ResultadoEsperadoEntity;
import vinicius.ferneda.tcc.certics.persistence.ResultadoEsperadoDAO;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

@BusinessController
public class ResultadoEsperadoBC extends DelegateCrud<ResultadoEsperadoEntity, Long, ResultadoEsperadoDAO> {
	private static final long serialVersionUID = 1L;
	
	public List<SelectItem> getEnumVersaoCertics() {
		List<SelectItem> varEnumVersaoCertics = new ArrayList<SelectItem>();
		for (EnumVersaoCertics eachEnumVersaoCertics : EnumVersaoCertics.values()) {
			varEnumVersaoCertics.add(new SelectItem(eachEnumVersaoCertics, eachEnumVersaoCertics.getNome()));
		}
		return varEnumVersaoCertics;
	}
	
}
