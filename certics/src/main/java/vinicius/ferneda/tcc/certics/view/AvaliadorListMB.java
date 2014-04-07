package vinicius.ferneda.tcc.certics.view;

import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import vinicius.ferneda.tcc.certics.business.AvaliadorBC;
import vinicius.ferneda.tcc.certics.domain.Avaliador;

@ViewController
@NextView("./avaliador_edit.jsf")
@PreviousView("./avaliador_list.jsf")
public class AvaliadorListMB extends AbstractListPageBean<Avaliador, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private AvaliadorBC avaliadorBC;
	
	@Override
	protected List<Avaliador> handleResultList() {
		return this.avaliadorBC.findAll();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				avaliadorBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}