
package vinicius.ferneda.tcc.certics.business;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import vinicius.ferneda.tcc.certics.constant.EnumPontuacaoEvidencia;
import vinicius.ferneda.tcc.certics.domain.RespostaEvidencia;
import vinicius.ferneda.tcc.certics.persistence.RespostaEvidenciaDAO;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

@BusinessController
public class RespostaEvidenciaBC extends DelegateCrud<RespostaEvidencia, Long, RespostaEvidenciaDAO> {
	private static final long serialVersionUID = 1L;
	
	
	public List<SelectItem> getEnumPontuacaoEvidencia() {
		List<SelectItem> varEnumPontuacaoEvidencia = new ArrayList<SelectItem>();
		for (EnumPontuacaoEvidencia eachEnumPontuacaoEvidencia : EnumPontuacaoEvidencia.values()) {
			varEnumPontuacaoEvidencia.add(new SelectItem(eachEnumPontuacaoEvidencia.getNome()));
		}
		return varEnumPontuacaoEvidencia;
	}
	
}
