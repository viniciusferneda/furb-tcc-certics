package vinicius.ferneda.tcc.certics.view;

import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import vinicius.ferneda.tcc.certics.business.VersaoCerticsEntityBC;
import vinicius.ferneda.tcc.certics.domain.VersaoCerticsEntity;

@ViewController
@PreviousView("./versaoCerticsEntity_list.jsf")
public class VersaoCerticsEntityEditMB extends AbstractEditPageBean<VersaoCerticsEntity, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private VersaoCerticsEntityBC versaoCerticsEntityBC;
	
	@Override
	@Transactional
	public String delete() {
		this.versaoCerticsEntityBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		this.versaoCerticsEntityBC.insert(getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.versaoCerticsEntityBC.update(getBean());
		return getPreviousView();
	}

	@Override
	protected VersaoCerticsEntity handleLoad(Long id) {
		return this.versaoCerticsEntityBC.load(id);
	}

}