package vinicius.ferneda.tcc.certics.view;

import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import vinicius.ferneda.tcc.certics.business.SoftwareBC;
import vinicius.ferneda.tcc.certics.domain.Software;

@ViewController
@NextView("./software_edit.jsf")
@PreviousView("./software_list.jsf")
public class SoftwareListMB extends AbstractListPageBean<Software, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private SoftwareBC softwareBC;
	
	@Override
	protected List<Software> handleResultList() {
		return this.softwareBC.findAll();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				softwareBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}