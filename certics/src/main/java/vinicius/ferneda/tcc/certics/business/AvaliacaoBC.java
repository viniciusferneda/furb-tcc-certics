
package vinicius.ferneda.tcc.certics.business;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import vinicius.ferneda.tcc.certics.constant.EnumPontuacaoAvaliacao;
import vinicius.ferneda.tcc.certics.domain.AvaliacaoEntity;
import vinicius.ferneda.tcc.certics.persistence.AvaliacaoDAO;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

@BusinessController
public class AvaliacaoBC extends DelegateCrud<AvaliacaoEntity, Long, AvaliacaoDAO> {
	
	private static final long serialVersionUID = 1L;
	
	public List<SelectItem> getEnumPontuacaoAvaliacao() {
		List<SelectItem> varEnumPontuacaoAvaliacao = new ArrayList<SelectItem>();
		for (EnumPontuacaoAvaliacao eachEnumPontuacaoAvaliacao : EnumPontuacaoAvaliacao.values()) {
			varEnumPontuacaoAvaliacao.add(new SelectItem(eachEnumPontuacaoAvaliacao, eachEnumPontuacaoAvaliacao.getNome()));
		}
		return varEnumPontuacaoAvaliacao;
	}
	
}
