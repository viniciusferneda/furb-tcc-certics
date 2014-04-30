package vinicius.ferneda.tcc.certics.view;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import vinicius.ferneda.tcc.certics.business.EvidenciaBC;
import vinicius.ferneda.tcc.certics.domain.EvidenciaEntity;
import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;

@ViewController
@NextView("./evidencia_edit.jsf")
@PreviousView("./evidencia_list.jsf")
public class EvidenciaListMB extends AbstractListPageBean<EvidenciaEntity, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private EvidenciaBC evidenciaBC;
	
	@Override
	protected List<EvidenciaEntity> handleResultList() {
		return this.evidenciaBC.findAll();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				evidenciaBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}