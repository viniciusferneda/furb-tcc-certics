package vinicius.ferneda.tcc.certics.view;

import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import vinicius.ferneda.tcc.certics.business.EvidenciaEntityBC;
import vinicius.ferneda.tcc.certics.domain.EvidenciaEntity;

@ViewController
@NextView("./evidenciaEntity_edit.jsf")
@PreviousView("./evidenciaEntity_list.jsf")
public class EvidenciaEntityListMB extends AbstractListPageBean<EvidenciaEntity, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private EvidenciaEntityBC evidenciaEntityBC;
	
	@Override
	protected List<EvidenciaEntity> handleResultList() {
		return this.evidenciaEntityBC.findAll();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				evidenciaEntityBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}