package vinicius.ferneda.tcc.certics.view;

import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;

import vinicius.ferneda.tcc.certics.business.OrganizacaoSolicitanteBC;
import vinicius.ferneda.tcc.certics.domain.OrganizacaoSolicitanteEntity;
import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;

@ViewController
@NextView("./organizacaoSolicitante_edit.jsf")
@PreviousView("./organizacaoSolicitante_list.jsf")
public class OrganizacaoSolicitanteListMB extends AbstractListPageBean<OrganizacaoSolicitanteEntity, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private OrganizacaoSolicitanteBC organizacaoSolicitanteBC;
	
	@Override
	protected List<OrganizacaoSolicitanteEntity> handleResultList() {
		return this.organizacaoSolicitanteBC.findAll();
	}
	
	@Transactional
	public String deleteSelection() {
		boolean delete;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			delete = getSelection().get(id);
			if (delete) {
				organizacaoSolicitanteBC.delete(id);
				iter.remove();
			}
		}
		return getPreviousView();
	}

}