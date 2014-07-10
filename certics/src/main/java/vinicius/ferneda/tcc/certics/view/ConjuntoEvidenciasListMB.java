package vinicius.ferneda.tcc.certics.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import vinicius.ferneda.tcc.certics.business.AvaliacaoBC;
import vinicius.ferneda.tcc.certics.constant.EnumPapelUsuario;
import vinicius.ferneda.tcc.certics.domain.AvaliacaoEntity;
import vinicius.ferneda.tcc.certics.domain.ProfissionalEntity;
import vinicius.ferneda.tcc.certics.persistence.AvaliacaoDAO;
import vinicius.ferneda.tcc.certics.persistence.ProfissionalDAO;
import vinicius.ferneda.tcc.certics.reports.ExportarRelatorio;
import vinicius.ferneda.tcc.certics.security.Identity;
import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.security.SecurityContext;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;

@ViewController
@NextView("./conjuntoEvidencias_edit.jsf")
@PreviousView("./conjuntoEvidencias_list.jsf")
public class ConjuntoEvidenciasListMB extends AbstractListPageBean<AvaliacaoEntity, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private AvaliacaoBC avaliacaoBC;
	@Inject
	private AvaliacaoDAO avaliacaoDAO;
	@Inject
	private ProfissionalDAO profissionalDAO;
	
	@Inject
    private SecurityContext securityContext;
	@Inject
    private Identity identity;
	
	@Override
	protected List<AvaliacaoEntity> handleResultList() {
		if(securityContext.hasRole(EnumPapelUsuario.AVALIADOR.toString())){
			return this.avaliacaoDAO.findByAvaliadorIDDataAtual(Long.valueOf(identity.getId()));
		}else if(securityContext.hasRole(EnumPapelUsuario.AVALIADO.toString())){
			ProfissionalEntity profissionalEntity = this.profissionalDAO.findById(Long.valueOf(identity.getId()));
			if(profissionalEntity != null && profissionalEntity.getOrganizacaoSolicitante() != null){
				return this.avaliacaoDAO.findByOrganizacaoIDDataAtual(profissionalEntity.getOrganizacaoSolicitante().getId());
			}else{
				return new ArrayList<AvaliacaoEntity>();
			}
		}else if(securityContext.hasRole(EnumPapelUsuario.ADM.toString())){
			return this.avaliacaoBC.findAll();
		}else{
			return new ArrayList<AvaliacaoEntity>();
		}
		
	}
	
	/**
	 * Método responsável por exportar o relatório das evidências registradas na avaliação selecionada 
	 */
	public void exibirRelatorioEvidencias() {
		String avaliacaoIds = getAvaliacaoIDs();
		Map<String, Object> mapParametros = new HashMap<String, Object>();
		mapParametros.put("AVA_ID", avaliacaoIds);
		mapParametros.put("SUBREPORT_DIR", "reports/relatorioavaliacaodetalhado/");
		ExportarRelatorio relatorio = new ExportarRelatorio("reports/relatorioavaliacaodetalhado/RelatorioAvaliacaoDetalhado.jasper");
		relatorio.exportarRelatorioPdf(mapParametros, (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse(), "Relatorio_Evidencias");
	}

	/**
	 * Método responsável por exportar o relatório dos resultados esperados pendentes e um gráfico com a quantidade de evidências registradas
	 */
	public void exibirRelatorioGraficoAtendimentoAreasCompetencia() {
		String avaliacaoIds = getAvaliacaoIDs();
		Map<String, Object> mapParametros = new HashMap<String, Object>();
		mapParametros.put("AVA_ID", avaliacaoIds);
		ExportarRelatorio relatorio = new ExportarRelatorio("reports/relatoriograficoatendimentoareascompetencia/RelatorioGraficoAtendimentoAreasCompetencia.jasper");
		relatorio.exportarRelatorioPdf(mapParametros, (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse(), "Relatorio_Grafico_Atendimento_Areas_Competencia");
	}

	private String getAvaliacaoIDs() {
		String avaliacaoIds = null;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			Long id = iter.next();
			if(getSelection().get(id)){
				if(avaliacaoIds == null){
					avaliacaoIds = String.valueOf(id);
				}else{
					avaliacaoIds += ","+String.valueOf(id);
				}
			}
		}
		return avaliacaoIds;
	}

}