
package vinicius.ferneda.tcc.certics.view;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.primefaces.model.DualListModel;

import vinicius.ferneda.tcc.certics.business.AreaCompetenciaBC;
import vinicius.ferneda.tcc.certics.business.ResultadoEsperadoBC;
import vinicius.ferneda.tcc.certics.business.VersaoCerticsEntityBC;
import vinicius.ferneda.tcc.certics.domain.AreaCompetenciaEntity;
import vinicius.ferneda.tcc.certics.domain.ResultadoEsperadoEntity;
import vinicius.ferneda.tcc.certics.domain.VersaoCerticsEntity;
import vinicius.ferneda.tcc.certics.domain.VersaoCerticsResultadoEsperadoEntity;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;

@ViewController
@PreviousView("./resultadoEsperado_list.jsf")
public class ResultadoEsperadoEditMB extends AbstractEditPageBean<ResultadoEsperadoEntity, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private ResultadoEsperadoBC resultadoEsperadoBC;

	@Inject
	private VersaoCerticsEntityBC versaoCerticsEntityBC;
	private DualListModel<VersaoCerticsEntity> lVersaoCertics;
	
	@Inject
	private AreaCompetenciaBC areaCompetenciaBC;
	
	public List<AreaCompetenciaEntity> getAreaCompetenciaList(){
		return areaCompetenciaBC.findAll();
	}
	
	@Override
	@Transactional
	public String delete() {
		this.resultadoEsperadoBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		this.resultadoEsperadoBC.insert(this.getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.resultadoEsperadoBC.update(this.getBean());
		return getPreviousView();
	}
	
	@Override
	protected ResultadoEsperadoEntity handleLoad(Long id) {
		return this.resultadoEsperadoBC.load(id);
	}
	
	@Override
	protected ResultadoEsperadoEntity createBean() {
		ResultadoEsperadoEntity resultadoEsperado = super.createBean();
		//cria a lista de versões
		List<VersaoCerticsResultadoEsperadoEntity> lVersaoCerticsAreaCompetencia = resultadoEsperado.getlVersaoCerticsResultadoEsperado();
		List<VersaoCerticsEntity> lVersaoCertics = new ArrayList<VersaoCerticsEntity>();
		for (VersaoCerticsResultadoEsperadoEntity versao : lVersaoCerticsAreaCompetencia) {
			lVersaoCertics.add(versao.getVersaoCertics());
		}
		this.lVersaoCertics = new DualListModel<VersaoCerticsEntity>(this.versaoCerticsEntityBC.findAll(), lVersaoCertics);
		return resultadoEsperado;
	}
	
	public DualListModel<VersaoCerticsEntity> getlVersaoCertics() {
		return lVersaoCertics;
	}

	public void setlVersaoCertics(DualListModel<VersaoCerticsEntity> lVersaoCertics) {
		this.lVersaoCertics = lVersaoCertics;
	}
	
}