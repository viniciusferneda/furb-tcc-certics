
package vinicius.ferneda.tcc.certics.view;

import java.util.List;

import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.inject.Inject;

import vinicius.ferneda.tcc.certics.business.AvaliacaoBC;
import vinicius.ferneda.tcc.certics.business.AvaliadorBC;
import vinicius.ferneda.tcc.certics.business.SoftwareBC;
import vinicius.ferneda.tcc.certics.domain.Avaliacao;
import vinicius.ferneda.tcc.certics.domain.Avaliador;
import vinicius.ferneda.tcc.certics.domain.LicaoAprendida;
import vinicius.ferneda.tcc.certics.domain.RespostaEvidencia;
import vinicius.ferneda.tcc.certics.domain.Software;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;

@ViewController
@PreviousView("./avaliacao_list.jsf")
public class AvaliacaoEditMB extends AbstractEditPageBean<Avaliacao, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private AvaliacaoBC avaliacaoBC;
	

	public List<SelectItem> getVersaoCertics() {
		return avaliacaoBC.getEnumVersaoCertics();
	}
	public List<SelectItem> getPontuacao() {
		return avaliacaoBC.getEnumPontuacaoAvaliacao();
	}
	@Inject
	private SoftwareBC softwareBC;
	
	public List<Software> getSoftwareList(){
		return softwareBC.findAll();
	}
			
	@Inject
	private AvaliadorBC avaliadorBC;
	
	public List<Avaliador> getAvaliadorList(){
		return avaliadorBC.findAll();
	}
			
	private DataModel<LicaoAprendida> licaoAprendidaList;
	
	public void addLicaoAprendida() {
		this.getBean().getLicoesAprendidas().add(new LicaoAprendida());
	}
	public void deleteLicaoAprendida() {
	   this.getBean().getLicoesAprendidas().remove(getLicaoAprendidaList().getRowData());
	}
	public DataModel<LicaoAprendida> getLicaoAprendidaList() {
	   if (licaoAprendidaList == null) {
		   licaoAprendidaList = new ListDataModel<LicaoAprendida>(this.getBean().getLicoesAprendidas());
	   }
	   return licaoAprendidaList;
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
		this.avaliacaoBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		this.avaliacaoBC.insert(this.getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.avaliacaoBC.update(this.getBean());
		return getPreviousView();
	}
	
	@Override
	protected Avaliacao handleLoad(Long id) {
		return this.avaliacaoBC.load(id);
	}	
}