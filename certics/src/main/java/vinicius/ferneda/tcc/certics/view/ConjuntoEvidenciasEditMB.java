
package vinicius.ferneda.tcc.certics.view;

import java.util.List;

import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.inject.Inject;

import org.primefaces.event.NodeSelectEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;

import vinicius.ferneda.tcc.certics.business.AvaliacaoBC;
import vinicius.ferneda.tcc.certics.business.ConjuntoEvidenciasBC;
import vinicius.ferneda.tcc.certics.business.EvidenciaEntityBC;
import vinicius.ferneda.tcc.certics.business.EvidenciaProfissionalBC;
import vinicius.ferneda.tcc.certics.business.ProfissionalBC;
import vinicius.ferneda.tcc.certics.business.RespostaEvidenciaBC;
import vinicius.ferneda.tcc.certics.domain.AnexoEntity;
import vinicius.ferneda.tcc.certics.domain.AreaCompetenciaEntity;
import vinicius.ferneda.tcc.certics.domain.AvaliacaoEntity;
import vinicius.ferneda.tcc.certics.domain.ConjuntoEvidenciasEntity;
import vinicius.ferneda.tcc.certics.domain.EvidenciaEntity;
import vinicius.ferneda.tcc.certics.domain.EvidenciaProfissionalEntity;
import vinicius.ferneda.tcc.certics.domain.RespostaEvidenciaEntity;
import vinicius.ferneda.tcc.certics.domain.ResultadoEsperadoEntity;
import vinicius.ferneda.tcc.certics.persistence.AreaCompetenciaDAO;
import vinicius.ferneda.tcc.certics.persistence.ConjuntoEvidenciasDAO;
import vinicius.ferneda.tcc.certics.persistence.EvidenciaProfissionalDAO;
import vinicius.ferneda.tcc.certics.persistence.RespostaEvidenciaDAO;
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
	private RespostaEvidenciaBC respostaEvidenciaBC;
	@Inject
	private EvidenciaEntityBC evidenciaBC;
	@Inject
	private ConjuntoEvidenciasBC conjuntoEvidenciasBC;
	@Inject
	private ProfissionalBC profissionalBC;
	@Inject
	private EvidenciaProfissionalBC evidenciaProfissionalBC; 

	@Inject
	private AreaCompetenciaDAO areaCompetenciaDAO;
	@Inject
	private ConjuntoEvidenciasDAO conjuntoEvidenciasDAO;
	@Inject
	private RespostaEvidenciaDAO respostaEvidenciaDAO;
	@Inject
	private EvidenciaProfissionalDAO evidenciaProfissionalDAO;
	
	public List<SelectItem> getPontuacao() {
		return conjuntoEvidenciasBC.getEnumPontuacaoAvaliacao();
	}
	
	private TreeNode root;
	private TreeNode selectedNode;

	private DataModel<RespostaEvidenciaEntity> lRespostaEvidencias;
	
	public DataModel<RespostaEvidenciaEntity> getlRespostaEvidencias(){
		return this.lRespostaEvidencias;
	}
	
	public List<SelectItem> getEvidenciaList(){
		return this.evidenciaBC.getEvidenciaList();
	}

	public List<SelectItem> getProfissionalList(){
		return this.profissionalBC.getProfissionalList();
	}

	private DataModel<EvidenciaProfissionalEntity> lEvidenciaProfissional;

	public void addEvidenciaProfissional() {
		this.getBean().getRespostaEvidenciaAux().getProfissionais().add(this.getBean().getEvidenciaProfissionalEntity());
		this.getBean().setEvidenciaProfissionalEntity(new EvidenciaProfissionalEntity());
	}
	
	public void deleteEvidenciaProfissional() {
		this.getBean().getRespostaEvidenciaAux().getProfissionais().remove(getlEvidenciaProfissional().getRowData());
	}
	
	public DataModel<EvidenciaProfissionalEntity> getlEvidenciaProfissional() {
	   if (lEvidenciaProfissional == null) {
		   lEvidenciaProfissional = new ListDataModel<EvidenciaProfissionalEntity>();
	   }
		
	   if(this.getBean().getRespostaEvidenciaAux() != null && this.getBean().getRespostaEvidenciaAux().getProfissionais() != null){
		   lEvidenciaProfissional = new ListDataModel<EvidenciaProfissionalEntity>(this.getBean().getRespostaEvidenciaAux().getProfissionais());
	   }
	   
	   return lEvidenciaProfissional;
	}
	
	private DataModel<AnexoEntity> anexoList;

	public void addAnexo() {
		this.getBean().getEvidenciaAux().getAnexos().add(new AnexoEntity());
	}
	public void deleteAnexo() {
	   this.getBean().getEvidenciaAux().getAnexos().remove(getAnexoList().getRowData());
	}
	public DataModel<AnexoEntity> getAnexoList() {
	   if (anexoList == null) {
		   if(this.getBean().getEvidenciaAux() == null){
			   anexoList = new ListDataModel<AnexoEntity>();
		   }else{
			   anexoList = new ListDataModel<AnexoEntity>(this.getBean().getEvidenciaAux().getAnexos());
		   }
	   }
	   return anexoList;
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
	protected AvaliacaoEntity handleLoad(Long id) {
		AvaliacaoEntity avaliacaoEntity = this.avaliacaoBC.load(id);
		avaliacaoEntity.setConjuntoEvidenciasAux(new ConjuntoEvidenciasEntity());
		return avaliacaoEntity;
	}

	@SuppressWarnings("unused")
	public TreeNode getRoot(){
		List<AreaCompetenciaEntity> lAreaCompetencia = this.areaCompetenciaDAO.findByVersaoCerticsAndAvaliacaoID(this.getId(), this.getBean().getVersaoCertics().getId());
		this.root = new DefaultTreeNode("root", null);
		for (AreaCompetenciaEntity areaCompetenciaEntity : lAreaCompetencia) {
			TreeNode areaCompetencia = new DefaultTreeNode(new InformacoesArvore(areaCompetenciaEntity.getId(), areaCompetenciaEntity.getTitulo(), "areaCompetencia"), root);
			for (ResultadoEsperadoEntity resultadoEsperadoEntity : areaCompetenciaEntity.getResultadosEsperados()) {
				TreeNode resultadoEsperado = new DefaultTreeNode(new InformacoesArvore(resultadoEsperadoEntity.getId(), resultadoEsperadoEntity.getTitulo(), "resultadoEsperado"), areaCompetencia);
			}
		}
		return this.root;
	}
	
	public TreeNode getSelectedNode() {
        return selectedNode;
    }
 
    public void setSelectedNode(TreeNode selectedNode) {
        this.selectedNode = selectedNode;
    }
    
    public void onNodeSelect(NodeSelectEvent event) {
    	if("resultadoEsperado".equals(((InformacoesArvore)event.getTreeNode().getData()).getTipo())){
    		this.getBean().setConjuntoEvidenciasAux(this.conjuntoEvidenciasDAO.findByResultadoEsperadoID(((InformacoesArvore)event.getTreeNode().getData()).getId()));   		
    		this.lRespostaEvidencias = new ListDataModel<RespostaEvidenciaEntity>(respostaEvidenciaDAO.findByConjuntoEvidenciaID(this.getBean().getConjuntoEvidenciasAux().getId())); 
    	}
    }

    public void novaRespostaEvidencia(){
    	this.getBean().setRespostaEvidenciaAux(new RespostaEvidenciaEntity());
    }
    
    public void novoProfissional(RespostaEvidenciaEntity respostaEvidenciaEntity){
    	respostaEvidenciaEntity.setProfissionais(evidenciaProfissionalDAO.findByRespostaEvidenciaID(respostaEvidenciaEntity.getId()));
    	this.getBean().setRespostaEvidenciaAux(respostaEvidenciaEntity);
    	this.getBean().setEvidenciaProfissionalEntity(new EvidenciaProfissionalEntity());
    }
    
	public void addRespostaEvidencia(){
		this.getBean().getRespostaEvidenciaAux().setConjuntoEvidencias(this.getBean().getConjuntoEvidenciasAux());
		this.respostaEvidenciaBC.insert(this.getBean().getRespostaEvidenciaAux());
		this.getBean().setRespostaEvidenciaAux(new RespostaEvidenciaEntity());
	}

	public void setNovaEvidencia(){
		this.getBean().setEvidenciaAux(new EvidenciaEntity());
	}

	public void setEvidencia(){
		this.evidenciaBC.insert(this.getBean().getEvidenciaAux());
	}

	public void insertEvidenciaProfissional(){
		for (EvidenciaProfissionalEntity profissional : this.getBean().getRespostaEvidenciaAux().getProfissionais()) {
			profissional.setRespostaEvidencia(this.getBean().getRespostaEvidenciaAux());
			if(profissional.getId() != null){
				this.evidenciaProfissionalBC.update(profissional);
			}else{
				this.evidenciaProfissionalBC.insert(profissional);
			}
		}
	}

}