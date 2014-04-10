

package vinicius.ferneda.tcc.certics.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import vinicius.ferneda.tcc.certics.constant.EnumPontuacaoEvidencia;
import vinicius.ferneda.tcc.certics.domain.AvaliacaoEntity;
import vinicius.ferneda.tcc.certics.domain.ConjuntoEvidenciasEntity;
import vinicius.ferneda.tcc.certics.domain.RespostaEvidencia;
import vinicius.ferneda.tcc.certics.domain.RespostaEvidenciaEntity;
import br.gov.frameworkdemoiselle.junit.DemoiselleRunner;

@RunWith(DemoiselleRunner.class)
public class RespostaEvidenciaBCTest {

    @Inject
	private RespostaEvidenciaBC respostaEvidenciaBC;
	
	@Before
	public void before() {
		for (RespostaEvidencia respostaEvidencia : respostaEvidenciaBC.findAll()) {
			respostaEvidenciaBC.delete(respostaEvidencia.getId());
		}
	}	
	
	
	@Test
	public void testInsert() {
				
		// modifique para inserir dados conforme o construtor
		RespostaEvidencia respostaEvidencia = new RespostaEvidenciaEntity(EnumPontuacaoEvidencia.F,"abrangencia","motivo","contribuicao",new AvaliacaoEntity(),new ConjuntoEvidenciasEntity());
		respostaEvidenciaBC.insert(respostaEvidencia);
		List<RespostaEvidencia> listOfRespostaEvidencia = respostaEvidenciaBC.findAll();
		assertNotNull(listOfRespostaEvidencia);
		assertEquals(1, listOfRespostaEvidencia.size());
	}	
	
	@Test
	public void testDelete() {
		
		// modifique para inserir dados conforme o construtor
		RespostaEvidencia respostaEvidencia = new RespostaEvidenciaEntity(EnumPontuacaoEvidencia.F,"abrangencia","motivo","contribuicao",new AvaliacaoEntity(),new ConjuntoEvidenciasEntity());
		respostaEvidenciaBC.insert(respostaEvidencia);
		
		List<RespostaEvidencia> listOfRespostaEvidencia = respostaEvidenciaBC.findAll();
		assertNotNull(listOfRespostaEvidencia);
		assertEquals(1, listOfRespostaEvidencia.size());
		
		respostaEvidenciaBC.delete(respostaEvidencia.getId());
		listOfRespostaEvidencia = respostaEvidenciaBC.findAll();
		assertEquals(0, listOfRespostaEvidencia.size());
	}
	
	@Test
	public void testUpdate() {
		// modifique para inserir dados conforme o construtor
		RespostaEvidencia respostaEvidencia = new RespostaEvidenciaEntity(EnumPontuacaoEvidencia.F,"abrangencia","motivo","contribuicao",new AvaliacaoEntity(),new ConjuntoEvidenciasEntity());
		respostaEvidenciaBC.insert(respostaEvidencia);
		
		List<RespostaEvidencia> listOfRespostaEvidencia = respostaEvidenciaBC.findAll();
		RespostaEvidencia respostaEvidencia2 = (RespostaEvidencia)listOfRespostaEvidencia.get(0);
		assertNotNull(listOfRespostaEvidencia);

		// alterar para tratar uma propriedade existente na Entidade RespostaEvidencia
		// respostaEvidencia2.setUmaPropriedade("novo valor");
		respostaEvidenciaBC.update(respostaEvidencia2);
		
		listOfRespostaEvidencia = respostaEvidenciaBC.findAll();
		RespostaEvidencia respostaEvidencia3 = (RespostaEvidencia)listOfRespostaEvidencia.get(0);
		
		// alterar para tratar uma propriedade existente na Entidade RespostaEvidencia
		assertEquals("novo valor", respostaEvidencia3.getAvaliacao());
	}

}