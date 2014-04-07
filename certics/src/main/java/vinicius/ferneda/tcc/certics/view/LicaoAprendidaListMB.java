package vinicius.ferneda.tcc.certics.view;

import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import vinicius.ferneda.tcc.certics.business.LicaoAprendidaBC;
import vinicius.ferneda.tcc.certics.domain.LicaoAprendida;

@ViewController
@NextView("./licaoAprendida_edit.jsf")
@PreviousView("./licaoAprendida_list.jsf")
public class LicaoAprendidaListMB extends AbstractListPageBean<LicaoAprendida, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private LicaoAprendidaBC licaoAprendidaBC;
	
	@Override
	protected List<LicaoAprendida> handleResultList() {
		return this.licaoAprendidaBC.findAll();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				licaoAprendidaBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}