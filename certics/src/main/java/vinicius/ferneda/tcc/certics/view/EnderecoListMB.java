package vinicius.ferneda.tcc.certics.view;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import vinicius.ferneda.tcc.certics.business.EnderecoBC;
import vinicius.ferneda.tcc.certics.domain.EnderecoEntity;
import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;

@ViewController
@NextView("./endereco_edit.jsf")
@PreviousView("./endereco_list.jsf")
public class EnderecoListMB extends AbstractListPageBean<EnderecoEntity, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private EnderecoBC enderecoBC;
	
	@Override
	protected List<EnderecoEntity> handleResultList() {
		return this.enderecoBC.findAll();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				enderecoBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}