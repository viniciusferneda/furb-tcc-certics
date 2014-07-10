
package vinicius.ferneda.tcc.certics.view;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.model.SelectItem;
import javax.inject.Inject;

import org.primefaces.event.NodeSelectEvent;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.TreeNode;

import vinicius.ferneda.tcc.certics.business.AvaliacaoBC;
import vinicius.ferneda.tcc.certics.business.ConjuntoEvidenciasBC;
import vinicius.ferneda.tcc.certics.business.EvidenciaEntityBC;
import vinicius.ferneda.tcc.certics.business.EvidenciaProfissionalBC;
import vinicius.ferneda.tcc.certics.business.ProfissionalBC;
import vinicius.ferneda.tcc.certics.business.RespostaEvidenciaBC;
import vinicius.ferneda.tcc.certics.constant.EnumPapelUsuario;
import vinicius.ferneda.tcc.certics.constant.EnumPontuacaoAvaliacao;
import vinicius.ferneda.tcc.certics.domain.AnexoEntity;
import vinicius.ferneda.tcc.certics.domain.AreaCompetenciaEntity;
import vinicius.ferneda.tcc.certics.domain.AvaliacaoEntity;
import vinicius.ferneda.tcc.certics.domain.ConjuntoEvidenciasEntity;
import vinicius.ferneda.tcc.certics.domain.EvidenciaEntity;
import vinicius.ferneda.tcc.certics.domain.EvidenciaProfissionalEntity;
import vinicius.ferneda.tcc.certics.domain.RespostaEvidenciaEntity;
import vinicius.ferneda.tcc.certics.domain.ResultadoEsperadoEntity;
import vinicius.ferneda.tcc.certics.persistence.AnexoDAO;
import vinicius.ferneda.tcc.certics.persistence.AreaCompetenciaDAO;
import vinicius.ferneda.tcc.certics.persistence.ConjuntoEvidenciasDAO;
import vinicius.ferneda.tcc.certics.persistence.EvidenciaProfissionalDAO;
import vinicius.ferneda.tcc.certics.persistence.RespostaEvidenciaDAO;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.message.MessageContext;
import br.gov.frameworkdemoiselle.security.SecurityContext;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.util.ResourceBundle;

@ViewController
@PreviousView("./conjuntoEvidencias_list.jsf")
public class ConjuntoEvidenciasEditMB extends AbstractEditPageBean<AvaliacaoEntity, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
    private SecurityContext securityContext;
	@Inject
	private MessageContext messageContext;
	@Inject
	private ResourceBundle bundle;
	
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
	@Inject
	private AnexoDAO anexoDAO;
	
	private TreeNode root;
	private TreeNode selectedNode;
	private StreamedContent file;
	private DataModel<AnexoEntity> lAnexos;
	private DataModel<RespostaEvidenciaEntity> lRespostaEvidencias;
	private DataModel<EvidenciaProfissionalEntity> lEvidenciaProfissional;

	public List<SelectItem> getPontuacao() {
		return conjuntoEvidenciasBC.getEnumPontuacaoAvaliacao();
	}
	
	public List<SelectItem> getEvidenciaList(){
		return this.evidenciaBC.getEvidenciaList();
	}

	public List<SelectItem> getProfissionalList(){
		return this.profissionalBC.getProfissionalList();
	}

	public DataModel<RespostaEvidenciaEntity> getlRespostaEvidencias(){
		return this.lRespostaEvidencias = new ListDataModel<RespostaEvidenciaEntity>(respostaEvidenciaDAO.findByConjuntoEvidenciaID(this.getBean().getConjuntoEvidenciasAux().getId()));
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

	public DataModel<AnexoEntity> getlAnexos() {
	   if (lAnexos == null) {
		   lAnexos = new ListDataModel<AnexoEntity>();
	   }
	   
	   if(this.getBean().getEvidenciaAux() != null && this.getBean().getEvidenciaAux().getAnexos() != null){
			lAnexos = new ListDataModel<AnexoEntity>(this.getBean().getEvidenciaAux().getAnexos());
	   }
	   return lAnexos;
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
    
    public void onNodeSelect(NodeSelectEvent event) {
    	if("resultadoEsperado".equals(((InformacoesArvore)event.getTreeNode().getData()).getTipo())){
    		this.getBean().setConjuntoEvidenciasAux(this.conjuntoEvidenciasDAO.findByResultadoEsperadoID(((InformacoesArvore)event.getTreeNode().getData()).getId(), getId()));   		
    	}
    }

    public boolean mostraConjuntoEvidenciaAvaliador(){
    	if((securityContext.hasRole(EnumPapelUsuario.AVALIADOR.toString()) || securityContext.hasRole(EnumPapelUsuario.ADM.toString())) && getBean().getConjuntoEvidenciasAux() != null && getBean().getConjuntoEvidenciasAux().getId() != null){
    		return true;
    	}else{
    		return false;
    	}
    }

    public boolean mostraConjuntoEvidenciaAvaliado(){
    	if((securityContext.hasRole(EnumPapelUsuario.AVALIADO.toString()) || securityContext.hasRole(EnumPapelUsuario.ADM.toString())) && getBean().getConjuntoEvidenciasAux() != null && getBean().getConjuntoEvidenciasAux().getId() != null){
    		return true;
    	}else{
    		return false;
    	}
    }

    public void carregarEvidencia(EvidenciaEntity evidenciaEntity){
    	getBean().setEvidenciaAux(evidenciaEntity);
    	getBean().getEvidenciaAux().setAnexos(anexoDAO.findByEvidenciaID(evidenciaEntity.getId()));
    }
    
    public void carregarArquivoDownload(AnexoEntity anexo){
    	InputStream stream = new ByteArrayInputStream(anexo.getArquivo());
		setFile(new DefaultStreamedContent(stream, anexo.getNome(), anexo.getNome()));    	
    }
    
    public void novaRespostaEvidencia(){
    	this.getBean().setRespostaEvidenciaAux(new RespostaEvidenciaEntity());
    }

    public void novoProfissional(RespostaEvidenciaEntity respostaEvidenciaEntity){
    	carregaProfissionais(respostaEvidenciaEntity);
    	this.getBean().setEvidenciaProfissionalEntity(new EvidenciaProfissionalEntity());
    }
    
    public void carregaProfissionais(RespostaEvidenciaEntity respostaEvidenciaEntity){
    	respostaEvidenciaEntity.setProfissionais(evidenciaProfissionalDAO.findByRespostaEvidenciaID(respostaEvidenciaEntity.getId()));
    	this.getBean().setRespostaEvidenciaAux(respostaEvidenciaEntity);
    }

	public void deleteEvidenciaProfissional() {
		this.getBean().getRespostaEvidenciaAux().getProfissionais().remove(getlEvidenciaProfissional().getRowData());
	}

	public void addRespostaEvidencia(){
		this.getBean().getRespostaEvidenciaAux().setConjuntoEvidencias(this.getBean().getConjuntoEvidenciasAux());
		this.respostaEvidenciaBC.insert(this.getBean().getRespostaEvidenciaAux());
		this.getBean().setRespostaEvidenciaAux(new RespostaEvidenciaEntity());
	}

	public void updateRespostaEvidencia(){
		this.respostaEvidenciaBC.update(this.getBean().getRespostaEvidenciaAux());
		this.getBean().setRespostaEvidenciaAux(new RespostaEvidenciaEntity());
	}
	
	public void editarEvidencia(RespostaEvidenciaEntity respostaEvidenciaEntity){
		getBean().setRespostaEvidenciaAux(respostaEvidenciaEntity);
	}
	
	public void excluirEvidencia(RespostaEvidenciaEntity respostaEvidenciaEntity){
		for (RespostaEvidenciaEntity resposta : this.lRespostaEvidencias) {
			if(respostaEvidenciaEntity.getId().equals(resposta.getId())){
				respostaEvidenciaBC.delete(respostaEvidenciaEntity.getId());
			}
		}
	}

	public void setNovaEvidencia(){
		this.getBean().setEvidenciaAux(new EvidenciaEntity());
	}

	public void setEvidencia(){
		this.evidenciaBC.insert(this.getBean().getEvidenciaAux());
	}

	public void insertEvidenciaProfissional(){
		EvidenciaProfissionalEntity profissional = this.getBean().getEvidenciaProfissionalEntity();
		profissional.setRespostaEvidencia(this.getBean().getRespostaEvidenciaAux());
		if(profissional.getId() != null){
			this.evidenciaProfissionalBC.update(profissional);
		}else{
			this.evidenciaProfissionalBC.insert(profissional);
		}
		this.getBean().setEvidenciaProfissionalEntity(new EvidenciaProfissionalEntity());
	}
	
	public void editarEvidenciaProfissional(EvidenciaProfissionalEntity evidenciaProfissionalEntity){
		getBean().setEvidenciaProfissionalEntity(evidenciaProfissionalEntity);
	}
	
	public void excluirEvidenciaProfissional(EvidenciaProfissionalEntity evidenciaProfissionalEntity){
		for (EvidenciaProfissionalEntity eviProf : this.lEvidenciaProfissional) {
			if(evidenciaProfissionalEntity.getId().equals(eviProf.getId())){
				evidenciaProfissionalBC.delete(evidenciaProfissionalEntity.getId());
			}
		}
	}
	
	public void insertConjuntoEvidencia(){
		this.conjuntoEvidenciasBC.update(this.getBean().getConjuntoEvidenciasAux());
		atualizaPontuacaoAvaliacao();
		messageContext.add(bundle.getString("conjuntoEvidencias.msg.pontuacao.registrada.sucesso"));
	}

	private void atualizaPontuacaoAvaliacao() {
		int qtdRespostas = 0, completamenteAtendido = 0, largamenteAtendido = 0, parcialmenteAtendido = 0, naoAtendido = 0, naoRespondida = 0;
		for (ConjuntoEvidenciasEntity conjuntoEvidenciasEntity : conjuntoEvidenciasDAO.findByAvaliacaoID(getId())) {
			qtdRespostas++;
			if(conjuntoEvidenciasEntity.getPontuacao() != null){
				switch (conjuntoEvidenciasEntity.getPontuacao()) {
				case F:
					completamenteAtendido++;
					break;
				case L:
					largamenteAtendido++;
					break;
				case P: parcialmenteAtendido++;
					break;
				case N: naoAtendido++; 
					break;
				}
			}else{
				naoRespondida++;
			}
		}
		
		if(naoRespondida == 0 && (parcialmenteAtendido > 0 || naoAtendido > 0)){
			getBean().setPontuacao(EnumPontuacaoAvaliacao.REPROVADA);
		}else if(naoRespondida == 0 && qtdRespostas == (completamenteAtendido+largamenteAtendido)){
			getBean().setPontuacao(EnumPontuacaoAvaliacao.APROVADA);
		}else{
			getBean().setPontuacao(EnumPontuacaoAvaliacao.PENDENTE);
		}
		update();
	}

	public TreeNode getSelectedNode() {
        return selectedNode;
    }
 
    public void setSelectedNode(TreeNode selectedNode) {
        this.selectedNode = selectedNode;
    }

	public StreamedContent getFile() {
		return file;
	}

	public void setFile(StreamedContent file) {
		this.file = file;
	}

}