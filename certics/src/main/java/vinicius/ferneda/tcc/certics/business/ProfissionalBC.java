
package vinicius.ferneda.tcc.certics.business;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import vinicius.ferneda.tcc.certics.constant.EnumSexo;
import vinicius.ferneda.tcc.certics.constant.EnumUF;
import vinicius.ferneda.tcc.certics.domain.ProfissionalEntity;
import vinicius.ferneda.tcc.certics.persistence.ProfissionalDAO;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

@BusinessController
public class ProfissionalBC extends DelegateCrud<ProfissionalEntity, Long, ProfissionalDAO> {
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
	
	public List<SelectItem> getProfissionalList() {
		List<SelectItem> varProfissional = new ArrayList<SelectItem>();
		for (ProfissionalEntity profissional : this.findAll()) {
			varProfissional.add(new SelectItem(profissional, profissional.getNome()));
		}
		return varProfissional;
	}
	
}
