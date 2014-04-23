package vinicius.ferneda.tcc.certics.view;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import vinicius.ferneda.tcc.certics.business.RespostaEvidenciaBC;
import vinicius.ferneda.tcc.certics.domain.RespostaEvidenciaEntity;
import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;

@ViewController
@NextView("./respostaEvidencia_edit.jsf")
@PreviousView("./respostaEvidencia_list.jsf")
public class RespostaEvidenciaListMB extends AbstractListPageBean<RespostaEvidenciaEntity, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private RespostaEvidenciaBC respostaEvidenciaBC;
	
	@Override
	protected List<RespostaEvidenciaEntity> handleResultList() {
		return this.respostaEvidenciaBC.findAll();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				respostaEvidenciaBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}