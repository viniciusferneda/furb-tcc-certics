
package vinicius.ferneda.tcc.certics.view;

import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;

import vinicius.ferneda.tcc.certics.business.AvaliacaoBC;
import vinicius.ferneda.tcc.certics.domain.AreaCompetenciaEntity;
import vinicius.ferneda.tcc.certics.domain.AvaliacaoEntity;
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
	
	private DataModel<AreaCompetenciaEntity> lEvidencias;
	
	public DataModel<AreaCompetenciaEntity> getlEvidencias(){
		if(this.lEvidencias == null){
			this.lEvidencias = new ListDataModel<AreaCompetenciaEntity>(areaCompetenciaDAO.findByVersaoCerticsAndAvaliacaoID(this.getId(), this.getBean().getVersaoCertics()));
		}
		return this.lEvidencias;
	}
	
	/*private DataModel<ConjuntoEvidenciasEntity> lConjuntoEvidencias;
	public DataModel<ConjuntoEvidenciasEntity> getlConjuntoEvidencias() {
	   if (lConjuntoEvidencias == null) {
		   lConjuntoEvidencias = new ListDataModel<ConjuntoEvidenciasEntity>(this.getBean().getRespostas());
	   }
	   return lConjuntoEvidencias;
	}*/
	
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
	protected AvaliacaoEntity handleLoad(Long id) {
		AvaliacaoEntity avaliacao = this.avaliacaoBC.load(id);
		
		/*raiz = new DefaultTreeNode("Raiz", null);
		List<AreaCompetenciaEntity> lEvidencias = areaCompetenciaDAO.findByVersaoCerticsAndAvaliacaoID(avaliacao.getId(), avaliacao.getVersaoCertics());
		for (AreaCompetenciaEntity areaCompetenciaEntity : lEvidencias) {
			TreeNode areaCompentencia = new DefaultTreeNode(areaCompetenciaEntity.getTitulo(), raiz);
			for (ResultadoEsperadoEntity resultadoEsperadoEntity : areaCompetenciaEntity.getResultadosEsperados()) {
				TreeNode resultadoEsperado = new DefaultTreeNode(resultadoEsperadoEntity.getTitulo(), areaCompentencia);
				for (ConjuntoEvidenciasEntity conjuntoEvidenciasEntity : resultadoEsperadoEntity.getConjuntoEvidencias()) {
					TreeNode conjuntoEvidencias = new DefaultTreeNode("evidencia", resultadoEsperado);
				}
			}
		}*/
		
		return avaliacao;
	}

	/*private TreeNode raiz;
	public TreeNode getRaiz() {
        return this.raiz;
    }*/

}