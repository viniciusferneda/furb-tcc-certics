
package vinicius.ferneda.tcc.certics.view;

import java.util.List;

import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import vinicius.ferneda.tcc.certics.business.AvaliacaoBC;
import vinicius.ferneda.tcc.certics.domain.AreaCompetenciaEntity;
import vinicius.ferneda.tcc.certics.domain.AvaliacaoEntity;
import vinicius.ferneda.tcc.certics.domain.ConjuntoEvidenciasEntity;
import vinicius.ferneda.tcc.certics.domain.ResultadoEsperadoEntity;
import vinicius.ferneda.tcc.certics.persistence.AreaCompetenciaDAO;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;

@ViewController
@PreviousView("./conjuntoEvidencias_list.jsf")
public class ConjuntoEvidenciasEditMB extends AbstractEditPageBean<AvaliacaoEntity, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private AvaliacaoBC avaliacaoBC;

	@Inject
	private AreaCompetenciaDAO areaCompetenciaDAO;
	
	private DataModel<ConjuntoEvidenciasEntity> lConjuntoEvidencias;
	
	public DataModel<ConjuntoEvidenciasEntity> getlConjuntoEvidencias() {
	   if (lConjuntoEvidencias == null) {
		   lConjuntoEvidencias = new ListDataModel<ConjuntoEvidenciasEntity>(this.getBean().getRespostas());
	   }
	   return lConjuntoEvidencias;
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
	
	private TreeNode raiz;

	@SuppressWarnings("unused")
	@Override
	protected AvaliacaoEntity handleLoad(Long id) {
		AvaliacaoEntity avaliacao = this.avaliacaoBC.load(id);
		
		raiz = new DefaultTreeNode("Raiz", null);
		List<AreaCompetenciaEntity> lEvidencias = areaCompetenciaDAO.findByVersaoCerticsAndAvaliacaoID(avaliacao.getId(), avaliacao.getVersaoCertics());
		for (AreaCompetenciaEntity areaCompetenciaEntity : lEvidencias) {
			TreeNode areaCompentencia = new DefaultTreeNode(areaCompetenciaEntity.getTitulo(), raiz);
			for (ResultadoEsperadoEntity resultadoEsperadoEntity : areaCompetenciaEntity.getResultadosEsperados()) {
				TreeNode resultadoEsperado = new DefaultTreeNode(resultadoEsperadoEntity.getTitulo(), areaCompentencia);
				for (int i = 0; i < resultadoEsperadoEntity.getConjuntoEvidencias().size(); i++) {
					TreeNode conjuntoEvidencias = new DefaultTreeNode("Evidências", resultadoEsperado);
				}
			}
		}
		
		return avaliacao;
	}

	public TreeNode getRaiz() {
        return this.raiz;
    }

}