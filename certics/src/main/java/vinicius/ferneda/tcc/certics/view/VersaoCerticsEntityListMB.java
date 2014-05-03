package vinicius.ferneda.tcc.certics.view;

import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import vinicius.ferneda.tcc.certics.business.VersaoCerticsEntityBC;
import vinicius.ferneda.tcc.certics.domain.VersaoCerticsEntity;

@ViewController
@NextView("./versaoCerticsEntity_edit.jsf")
@PreviousView("./versaoCerticsEntity_list.jsf")
public class VersaoCerticsEntityListMB extends AbstractListPageBean<VersaoCerticsEntity, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private VersaoCerticsEntityBC versaoCerticsEntityBC;
	
	@Override
	protected List<VersaoCerticsEntity> handleResultList() {
		return this.versaoCerticsEntityBC.findAll();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				versaoCerticsEntityBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}