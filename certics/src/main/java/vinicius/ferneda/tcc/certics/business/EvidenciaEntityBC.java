package vinicius.ferneda.tcc.certics.business;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

import vinicius.ferneda.tcc.certics.domain.EvidenciaEntity;
import vinicius.ferneda.tcc.certics.persistence.EvidenciaEntityDAO;

@BusinessController
public class EvidenciaEntityBC extends DelegateCrud<EvidenciaEntity, Long, EvidenciaEntityDAO> {
	
	private static final long serialVersionUID = 1L;
	
	public List<SelectItem> getEvidenciaList() {
		List<SelectItem> varEvidencia = new ArrayList<SelectItem>();
		for (EvidenciaEntity evidencia : this.findAll()) {
			varEvidencia.add(new SelectItem(evidencia, evidencia.getNome()));
		}
		return varEvidencia;
	}
	
}
