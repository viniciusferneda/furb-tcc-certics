
package vinicius.ferneda.tcc.certics.view;

import java.util.List;

import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.inject.Inject;

import vinicius.ferneda.tcc.certics.business.AvaliadorBC;
import vinicius.ferneda.tcc.certics.business.EnderecoBC;
import vinicius.ferneda.tcc.certics.domain.Avaliacao;
import vinicius.ferneda.tcc.certics.domain.Avaliador;
import vinicius.ferneda.tcc.certics.domain.Endereco;
import vinicius.ferneda.tcc.certics.domain.Usuario;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;

@ViewController
@PreviousView("./avaliador_list.jsf")
public class AvaliadorEditMB extends AbstractEditPageBean<Avaliador, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private AvaliadorBC avaliadorBC;
	

	private DataModel<Usuario> usuarioList;
	
	public void addUsuario() {
		this.getBean().getUsuarios().add(new Usuario());
	}
	public void deleteUsuario() {
	   this.getBean().getUsuarios().remove(getUsuarioList().getRowData());
	}
	public DataModel<Usuario> getUsuarioList() {
	   if (usuarioList == null) {
		   usuarioList = new ListDataModel<Usuario>(this.getBean().getUsuarios());
	   }
	   return usuarioList;
	} 
	private DataModel<Avaliacao> avaliacaoList;
	
	public void addAvaliacao() {
		this.getBean().getAvaliacoes().add(new Avaliacao());
	}
	public void deleteAvaliacao() {
	   this.getBean().getAvaliacoes().remove(getAvaliacaoList().getRowData());
	}
	public DataModel<Avaliacao> getAvaliacaoList() {
	   if (avaliacaoList == null) {
		   avaliacaoList = new ListDataModel<Avaliacao>(this.getBean().getAvaliacoes());
	   }
	   return avaliacaoList;
	} 
	public List<SelectItem> getSexo() {
		return avaliadorBC.getEnumSexo();
	}
	@Inject
	private EnderecoBC enderecoBC;
	
	public List<Endereco> getEnderecoList(){
		return enderecoBC.findAll();
	}
			
	
	@Override
	@Transactional
	public String delete() {
		this.avaliadorBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		this.avaliadorBC.insert(this.getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.avaliadorBC.update(this.getBean());
		return getPreviousView();
	}
	
	@Override
	protected Avaliador handleLoad(Long id) {
		return this.avaliadorBC.load(id);
	}	
}