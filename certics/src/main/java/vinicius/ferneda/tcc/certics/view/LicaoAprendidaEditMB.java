
package vinicius.ferneda.tcc.certics.view;

import java.util.List;

import javax.inject.Inject;

import vinicius.ferneda.tcc.certics.business.AvaliacaoBC;
import vinicius.ferneda.tcc.certics.business.LicaoAprendidaBC;
import vinicius.ferneda.tcc.certics.domain.Avaliacao;
import vinicius.ferneda.tcc.certics.domain.LicaoAprendida;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;

@ViewController
@PreviousView("./licaoAprendida_list.jsf")
public class LicaoAprendidaEditMB extends AbstractEditPageBean<LicaoAprendida, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private LicaoAprendidaBC licaoAprendidaBC;
	

	@Inject
	private AvaliacaoBC avaliacaoBC;
	
	public List<Avaliacao> getAvaliacaoList(){
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
	protected LicaoAprendida handleLoad(Long id) {
		return this.licaoAprendidaBC.load(id);
	}	
}