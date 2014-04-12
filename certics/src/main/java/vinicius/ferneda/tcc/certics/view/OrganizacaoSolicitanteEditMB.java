
package vinicius.ferneda.tcc.certics.view;

import java.util.List;

import javax.faces.model.SelectItem;
import javax.inject.Inject;

import vinicius.ferneda.tcc.certics.business.EnderecoBC;
import vinicius.ferneda.tcc.certics.business.OrganizacaoSolicitanteBC;
import vinicius.ferneda.tcc.certics.domain.EnderecoEntity;
import vinicius.ferneda.tcc.certics.domain.OrganizacaoSolicitanteEntity;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;

@ViewController
@PreviousView("./organizacaoSolicitante_list.jsf")
public class OrganizacaoSolicitanteEditMB extends AbstractEditPageBean<OrganizacaoSolicitanteEntity, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private OrganizacaoSolicitanteBC organizacaoSolicitanteBC;

	@Inject
	private EnderecoBC enderecoBC;
	
	public List<SelectItem> getUf() {
		return organizacaoSolicitanteBC.getEnumUF();
	}
	
	@Override
	@Transactional
	public String delete() {
		this.organizacaoSolicitanteBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		//grava Endereco
		this.enderecoBC.insert(this.getBean().getEndereco());
				
		this.organizacaoSolicitanteBC.insert(this.getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.organizacaoSolicitanteBC.update(this.getBean());
		return getPreviousView();
	}
	
	@Override
	protected OrganizacaoSolicitanteEntity handleLoad(Long id) {
		return this.organizacaoSolicitanteBC.load(id);
	}
	
	@Override
	protected OrganizacaoSolicitanteEntity createBean() {
		OrganizacaoSolicitanteEntity organizacaoSolicitante = super.createBean();
		organizacaoSolicitante.setEndereco(new EnderecoEntity());
		return organizacaoSolicitante;
	}
}