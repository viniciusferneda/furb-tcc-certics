package vinicius.ferneda.tcc.certics.view;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import vinicius.ferneda.tcc.certics.business.ProfissionalBC;
import vinicius.ferneda.tcc.certics.domain.ProfissionalEntity;
import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;

@ViewController
@NextView("./profissional_edit.jsf")
@PreviousView("./profissional_list.jsf")
public class ProfissionalListMB extends AbstractListPageBean<ProfissionalEntity, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private ProfissionalBC profissionalBC;
	
	@Override
	protected List<ProfissionalEntity> handleResultList() {
		return this.profissionalBC.findAll();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				profissionalBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}