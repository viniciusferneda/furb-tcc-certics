package vinicius.ferneda.tcc.certics.view;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import vinicius.ferneda.tcc.certics.business.AvaliacaoBC;
import vinicius.ferneda.tcc.certics.domain.AvaliacaoEntity;
import vinicius.ferneda.tcc.certics.persistence.AvaliacaoDAO;
import vinicius.ferneda.tcc.certics.reports.ExportarRelatorio;
import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
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
	
	@Override
	protected List<AvaliacaoEntity> handleResultList() {
		return this.avaliacaoBC.findAll();
	}
	
	/**
	 * Método responsável por exportar o relatório das evidências registradas na avaliação selecionada 
	 */
	public void exibirRelatorioEvidencias() {
		String avaliacaoIds = null;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			if(avaliacaoIds == null){
				avaliacaoIds = String.valueOf(iter.next());
			}else{
				avaliacaoIds = ","+String.valueOf(iter.next());
			}
		}
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
		String avaliacaoIds = null;
		for (Iterator<Long> iter = getSelection().keySet().iterator(); iter.hasNext();) {
			if(avaliacaoIds == null){
				avaliacaoIds = String.valueOf(iter.next());
			}else{
				avaliacaoIds = ","+String.valueOf(iter.next());
			}
		}
		Map<String, Object> mapParametros = new HashMap<String, Object>();
		mapParametros.put("AVA_ID", avaliacaoIds);
		ExportarRelatorio relatorio = new ExportarRelatorio("reports/relatoriograficoatendimentoareascompetencia/RelatorioGraficoAtendimentoAreasCompetencia.jasper");
		relatorio.exportarRelatorioPdf(mapParametros, (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse(), "Relatorio_Grafico_Atendimento_Areas_Competencia");
	}
	
}