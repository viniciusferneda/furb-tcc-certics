package vinicius.ferneda.tcc.certics.view;

import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import vinicius.ferneda.tcc.certics.business.ConjuntoEvidenciasBC;
import vinicius.ferneda.tcc.certics.domain.ConjuntoEvidencias;

@ViewController
@NextView("./conjuntoEvidencias_edit.jsf")
@PreviousView("./conjuntoEvidencias_list.jsf")
public class ConjuntoEvidenciasListMB extends AbstractListPageBean<ConjuntoEvidencias, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private ConjuntoEvidenciasBC conjuntoEvidenciasBC;
	
	@Override
	protected List<ConjuntoEvidencias> handleResultList() {
		return this.conjuntoEvidenciasBC.findAll();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				conjuntoEvidenciasBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}