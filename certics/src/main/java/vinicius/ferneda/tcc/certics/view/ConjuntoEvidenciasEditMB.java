
package vinicius.ferneda.tcc.certics.view;

import java.util.List;

import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;

import vinicius.ferneda.tcc.certics.business.ConjuntoEvidenciasBC;
import vinicius.ferneda.tcc.certics.business.ResultadoEsperadoBC;
import vinicius.ferneda.tcc.certics.domain.ConjuntoEvidencias;
import vinicius.ferneda.tcc.certics.domain.RespostaEvidencia;
import vinicius.ferneda.tcc.certics.domain.ResultadoEsperado;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;

@ViewController
@PreviousView("./conjuntoEvidencias_list.jsf")
public class ConjuntoEvidenciasEditMB extends AbstractEditPageBean<ConjuntoEvidencias, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private ConjuntoEvidenciasBC conjuntoEvidenciasBC;
	

	@Inject
	private ResultadoEsperadoBC resultadoEsperadoBC;
	
	public List<ResultadoEsperado> getResultadoEsperadoList(){
		return resultadoEsperadoBC.findAll();
	}
			
	private DataModel<RespostaEvidencia> respostaEvidenciaList;
	
	public void addRespostaEvidencia() {
		this.getBean().getRespostas().add(new RespostaEvidencia());
	}
	public void deleteRespostaEvidencia() {
	   this.getBean().getRespostas().remove(getRespostaEvidenciaList().getRowData());
	}
	public DataModel<RespostaEvidencia> getRespostaEvidenciaList() {
	   if (respostaEvidenciaList == null) {
		   respostaEvidenciaList = new ListDataModel<RespostaEvidencia>(this.getBean().getRespostas());
	   }
	   return respostaEvidenciaList;
	} 
	
	@Override
	@Transactional
	public String delete() {
		this.conjuntoEvidenciasBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		this.conjuntoEvidenciasBC.insert(this.getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.conjuntoEvidenciasBC.update(this.getBean());
		return getPreviousView();
	}
	
	@Override
	protected ConjuntoEvidencias handleLoad(Long id) {
		return this.conjuntoEvidenciasBC.load(id);
	}	
}