
package vinicius.ferneda.tcc.certics.view;

import java.util.List;

import javax.inject.Inject;

import vinicius.ferneda.tcc.certics.business.AvaliacaoBC;
import vinicius.ferneda.tcc.certics.business.LicaoAprendidaBC;
import vinicius.ferneda.tcc.certics.domain.AvaliacaoEntity;
import vinicius.ferneda.tcc.certics.domain.LicaoAprendidaEntity;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;

@ViewController
@PreviousView("./licaoAprendida_list.jsf")
public class LicaoAprendidaEditMB extends AbstractEditPageBean<LicaoAprendidaEntity, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private LicaoAprendidaBC licaoAprendidaBC;

	@Inject
	private AvaliacaoBC avaliacaoBC;
	
	public List<AvaliacaoEntity> getAvaliacaoList(){
		return avaliacaoBC.findAll();
	}
	
	@Override
	@Transactional
	public String delete() {
		this.licaoAprendidaBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		this.licaoAprendidaBC.insert(this.getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.licaoAprendidaBC.update(this.getBean());
		return getPreviousView();
	}
	
	@Override
	protected LicaoAprendidaEntity handleLoad(Long id) {
		return this.licaoAprendidaBC.load(id);
	}	
}