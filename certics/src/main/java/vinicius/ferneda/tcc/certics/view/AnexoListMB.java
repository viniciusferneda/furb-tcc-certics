package vinicius.ferneda.tcc.certics.view;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import vinicius.ferneda.tcc.certics.business.AnexoBC;
import vinicius.ferneda.tcc.certics.domain.AnexoEntity;
import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;

@ViewController
@NextView("./anexo_edit.jsf")
@PreviousView("./anexo_list.jsf")
public class AnexoListMB extends AbstractListPageBean<AnexoEntity, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private AnexoBC anexoBC;
	
	@Override
	protected List<AnexoEntity> handleResultList() {
		return this.anexoBC.findAll();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				anexoBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}