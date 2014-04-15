
package vinicius.ferneda.tcc.certics.view;

import java.util.List;

import javax.inject.Inject;

import vinicius.ferneda.tcc.certics.business.OrganizacaoSolicitanteBC;
import vinicius.ferneda.tcc.certics.business.SoftwareBC;
import vinicius.ferneda.tcc.certics.domain.OrganizacaoSolicitanteEntity;
import vinicius.ferneda.tcc.certics.domain.SoftwareEntity;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;

@ViewController
@PreviousView("./software_list.jsf")
public class SoftwareEditMB extends AbstractEditPageBean<SoftwareEntity, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private SoftwareBC softwareBC;

	@Inject
	private OrganizacaoSolicitanteBC organizacaoSolicitanteBC;
	
	public List<OrganizacaoSolicitanteEntity> getOrganizacaoSolicitanteList(){
		return organizacaoSolicitanteBC.findAll();
	}
	
	@Override
	@Transactional
	public String delete() {
		this.softwareBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		this.softwareBC.insert(this.getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.softwareBC.update(this.getBean());
		return getPreviousView();
	}
	
	@Override
	protected SoftwareEntity handleLoad(Long id) {
		return this.softwareBC.load(id);
	}	
	
}