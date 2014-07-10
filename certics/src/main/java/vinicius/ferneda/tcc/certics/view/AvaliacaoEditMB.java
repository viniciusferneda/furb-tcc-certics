package vinicius.ferneda.tcc.certics.view;

import java.util.List;

import javax.inject.Inject;

import vinicius.ferneda.tcc.certics.business.AvaliacaoBC;
import vinicius.ferneda.tcc.certics.business.ConjuntoEvidenciasBC;
import vinicius.ferneda.tcc.certics.business.ResultadoEsperadoBC;
import vinicius.ferneda.tcc.certics.business.SoftwareBC;
import vinicius.ferneda.tcc.certics.business.VersaoCerticsEntityBC;
import vinicius.ferneda.tcc.certics.constant.EnumPontuacaoAvaliacao;
import vinicius.ferneda.tcc.certics.domain.AvaliacaoEntity;
import vinicius.ferneda.tcc.certics.domain.AvaliadorEntity;
import vinicius.ferneda.tcc.certics.domain.SoftwareEntity;
import vinicius.ferneda.tcc.certics.domain.VersaoCerticsEntity;
import vinicius.ferneda.tcc.certics.persistence.AvaliadorDAO;
import vinicius.ferneda.tcc.certics.security.Identity;
import vinicius.ferneda.tcc.certics.util.DateUtils;
import vinicius.ferneda.tcc.certics.util.ExceptionUtils;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.util.ResourceBundle;

@ViewController
@PreviousView("./avaliacao_list.jsf")
public class AvaliacaoEditMB extends AbstractEditPageBean<AvaliacaoEntity, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private AvaliacaoBC avaliacaoBC;
	@Inject
	private ConjuntoEvidenciasBC conjuntoEvidenciasBC;
	@Inject
	private SoftwareBC softwareBC;
	@Inject
	private VersaoCerticsEntityBC versaoCerticsEntityBC;
	@Inject
	private ResultadoEsperadoBC resultadoEsperadoBC;
	
	@Inject
    private AvaliadorDAO avaliadorDAO;
	
	@Inject
    private ResourceBundle rb;
	@Inject
    private Identity identity;
	
	public List<SoftwareEntity> getSoftwareList(){
		return softwareBC.findAll();
	}
	
	public List<VersaoCerticsEntity> getVersaoCerticsList(){
		return versaoCerticsEntityBC.findAll();
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
		validaInformacoes();
		
		//registra o avaliador da avaliação
		AvaliadorEntity avaliadorEntity = this.avaliadorDAO.findById(Long.valueOf(identity.getId()));
		this.getBean().setAvaliador(avaliadorEntity);
		this.getBean().setPontuacao(EnumPontuacaoAvaliacao.PENDENTE);
		
		//insere o registro da avaliação
		this.avaliacaoBC.insert(this.getBean());
		
		//criação do conjunto de evidencias para o processo de registro
		this.conjuntoEvidenciasBC.criarConjuntoEvidencias(this.getBean());
		
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		validaInformacoes();
		this.avaliacaoBC.update(this.getBean());
		return getPreviousView();
	}
	
	@Override
	protected AvaliacaoEntity handleLoad(Long id) {
		return this.avaliacaoBC.load(id);
	}

	private void validaInformacoes(){
		if(DateUtils.dataMenorDataAtualSemHora(this.getBean().getDataAvaliacao())){
			throw new ExceptionUtils(rb.getString("avaliacao.erro.datainicio"));
		}
		
		if(!resultadoEsperadoBC.possuiResultadoEsperadoVersao(this.getBean().getVersaoCertics().getId())){
			throw new ExceptionUtils(rb.getString("avaliacao.erro.versaovazia"));
		}
	}
}