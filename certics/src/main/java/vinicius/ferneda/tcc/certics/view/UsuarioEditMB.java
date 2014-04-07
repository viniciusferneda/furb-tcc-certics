
package vinicius.ferneda.tcc.certics.view;

import java.util.List;

import javax.inject.Inject;

import vinicius.ferneda.tcc.certics.business.AvaliadorBC;
import vinicius.ferneda.tcc.certics.business.ProfissionalBC;
import vinicius.ferneda.tcc.certics.business.UsuarioBC;
import vinicius.ferneda.tcc.certics.domain.Avaliador;
import vinicius.ferneda.tcc.certics.domain.Profissional;
import vinicius.ferneda.tcc.certics.domain.Usuario;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;

@ViewController
@PreviousView("./usuario_list.jsf")
public class UsuarioEditMB extends AbstractEditPageBean<Usuario, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private UsuarioBC usuarioBC;
	

	@Inject
	private ProfissionalBC profissionalBC;
	
	public List<Profissional> getProfissionalList(){
		return profissionalBC.findAll();
	}
			
	@Inject
	private AvaliadorBC avaliadorBC;
	
	public List<Avaliador> getAvaliadorList(){
		return avaliadorBC.findAll();
	}
			
	
	@Override
	@Transactional
	public String delete() {
		this.usuarioBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		this.usuarioBC.insert(this.getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.usuarioBC.update(this.getBean());
		return getPreviousView();
	}
	
	@Override
	protected Usuario handleLoad(Long id) {
		return this.usuarioBC.load(id);
	}	
}