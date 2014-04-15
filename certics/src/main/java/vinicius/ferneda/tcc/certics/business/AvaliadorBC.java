package vinicius.ferneda.tcc.certics.business;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import vinicius.ferneda.tcc.certics.constant.EnumSexo;
import vinicius.ferneda.tcc.certics.constant.EnumUF;
import vinicius.ferneda.tcc.certics.domain.AvaliadorEntity;
import vinicius.ferneda.tcc.certics.persistence.AvaliadorDAO;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

@BusinessController
public class AvaliadorBC extends DelegateCrud<AvaliadorEntity, Long, AvaliadorDAO> {
	private static final long serialVersionUID = 1L;
	
	public List<SelectItem> getEnumSexo() {
		List<SelectItem> varEnumSexo = new ArrayList<SelectItem>();
		for (EnumSexo eachEnumSexo : EnumSexo.values()) {
			varEnumSexo.add(new SelectItem(eachEnumSexo,eachEnumSexo.getNome()));
		}
		return varEnumSexo;
	}
	
	public List<SelectItem> getEnumUF() {
		List<SelectItem> varEnumUF = new ArrayList<SelectItem>();
		for (EnumUF eachEnumUF : EnumUF.values()) {
			varEnumUF.add(new SelectItem(eachEnumUF, eachEnumUF.getNome()));
		}
		return varEnumUF;
	}
	
}
