package vinicius.ferneda.tcc.certics.view;

import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import vinicius.ferneda.tcc.certics.business.EvidenciaProfissionalBC;
import vinicius.ferneda.tcc.certics.domain.EvidenciaProfissional;

@ViewController
@NextView("./evidenciaProfissional_edit.jsf")
@PreviousView("./evidenciaProfissional_list.jsf")
public class EvidenciaProfissionalListMB extends AbstractListPageBean<EvidenciaProfissional, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private EvidenciaProfissionalBC evidenciaProfissionalBC;
	
	@Override
	protected List<EvidenciaProfissional> handleResultList() {
		return this.evidenciaProfissionalBC.findAll();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				evidenciaProfissionalBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}