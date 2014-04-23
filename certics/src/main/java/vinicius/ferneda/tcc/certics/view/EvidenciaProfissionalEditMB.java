
package vinicius.ferneda.tcc.certics.view;

import java.util.List;

import javax.inject.Inject;

import vinicius.ferneda.tcc.certics.business.EvidenciaProfissionalBC;
import vinicius.ferneda.tcc.certics.business.ProfissionalBC;
import vinicius.ferneda.tcc.certics.business.RespostaEvidenciaBC;
import vinicius.ferneda.tcc.certics.domain.EvidenciaProfissional;
import vinicius.ferneda.tcc.certics.domain.ProfissionalEntity;
import vinicius.ferneda.tcc.certics.domain.RespostaEvidenciaEntity;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;

@ViewController
@PreviousView("./evidenciaProfissional_list.jsf")
public class EvidenciaProfissionalEditMB extends AbstractEditPageBean<EvidenciaProfissional, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private EvidenciaProfissionalBC evidenciaProfissionalBC;
	

	@Inject
	private RespostaEvidenciaBC respostaEvidenciaBC;
	
	public List<RespostaEvidenciaEntity> getRespostaEvidenciaList(){
		return respostaEvidenciaBC.findAll();
	}
			
	@Inject
	private ProfissionalBC profissionalBC;
	
	public List<ProfissionalEntity> getProfissionalList(){
		return profissionalBC.findAll();
	}
			
	
	@Override
	@Transactional
	public String delete() {
		this.evidenciaProfissionalBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		this.evidenciaProfissionalBC.insert(this.getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.evidenciaProfissionalBC.update(this.getBean());
		return getPreviousView();
	}
	
	@Override
	protected EvidenciaProfissional handleLoad(Long id) {
		return this.evidenciaProfissionalBC.load(id);
	}	
}