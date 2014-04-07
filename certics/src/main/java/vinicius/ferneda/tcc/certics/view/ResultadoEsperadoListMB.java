package vinicius.ferneda.tcc.certics.view;

import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import vinicius.ferneda.tcc.certics.business.ResultadoEsperadoBC;
import vinicius.ferneda.tcc.certics.domain.ResultadoEsperado;

@ViewController
@NextView("./resultadoEsperado_edit.jsf")
@PreviousView("./resultadoEsperado_list.jsf")
public class ResultadoEsperadoListMB extends AbstractListPageBean<ResultadoEsperado, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private ResultadoEsperadoBC resultadoEsperadoBC;
	
	@Override
	protected List<ResultadoEsperado> handleResultList() {
		return this.resultadoEsperadoBC.findAll();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				resultadoEsperadoBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}