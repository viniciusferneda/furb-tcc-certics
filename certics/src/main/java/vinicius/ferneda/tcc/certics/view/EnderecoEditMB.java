
package vinicius.ferneda.tcc.certics.view;

import java.util.List;

import javax.faces.model.SelectItem;
import javax.inject.Inject;

import vinicius.ferneda.tcc.certics.business.EnderecoBC;
import vinicius.ferneda.tcc.certics.domain.EnderecoEntity;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;

@ViewController
@PreviousView("./endereco_list.jsf")
public class EnderecoEditMB extends AbstractEditPageBean<EnderecoEntity, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private EnderecoBC enderecoBC;
	

	public List<SelectItem> getUf() {
		return enderecoBC.getEnumUF();
	}
	
	@Override
	@Transactional
	public String delete() {
		this.enderecoBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		this.enderecoBC.insert(this.getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.enderecoBC.update(this.getBean());
		return getPreviousView();
	}
	
	@Override
	protected EnderecoEntity handleLoad(Long id) {
		return this.enderecoBC.load(id);
	}	
}