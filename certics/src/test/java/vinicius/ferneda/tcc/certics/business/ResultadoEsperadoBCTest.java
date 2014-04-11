

package vinicius.ferneda.tcc.certics.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import vinicius.ferneda.tcc.certics.constant.EnumVersaoCertics;
import vinicius.ferneda.tcc.certics.domain.AreaCompetenciaEntity;
import vinicius.ferneda.tcc.certics.domain.ResultadoEsperado;
import vinicius.ferneda.tcc.certics.domain.ResultadoEsperadoEntity;
import br.gov.frameworkdemoiselle.junit.DemoiselleRunner;

@RunWith(DemoiselleRunner.class)
public class ResultadoEsperadoBCTest {

    @Inject
	private ResultadoEsperadoBC resultadoEsperadoBC;
	
	@Before
	public void before() {
		for (ResultadoEsperado resultadoEsperado : resultadoEsperadoBC.findAll()) {
			resultadoEsperadoBC.delete(resultadoEsperado.getId());
		}
	}	
	
	
	@Test
	public void testInsert() {
				
		// modifique para inserir dados conforme o construtor
		ResultadoEsperadoEntity resultadoEsperado = new ResultadoEsperadoEntity("titulo","descricao",EnumVersaoCertics.V_1_0,new AreaCompetenciaEntity());
		resultadoEsperadoBC.insert(resultadoEsperado);
		List<ResultadoEsperadoEntity> listOfResultadoEsperado = resultadoEsperadoBC.findAll();
		assertNotNull(listOfResultadoEsperado);
		assertEquals(1, listOfResultadoEsperado.size());
	}	
	
	@Test
	public void testDelete() {
		
		// modifique para inserir dados conforme o construtor
		ResultadoEsperadoEntity resultadoEsperado = new ResultadoEsperadoEntity("titulo","descricao",EnumVersaoCertics.V_1_0,new AreaCompetenciaEntity());
		resultadoEsperadoBC.insert(resultadoEsperado);
		
		List<ResultadoEsperadoEntity> listOfResultadoEsperado = resultadoEsperadoBC.findAll();
		assertNotNull(listOfResultadoEsperado);
		assertEquals(1, listOfResultadoEsperado.size());
		
		resultadoEsperadoBC.delete(resultadoEsperado.getId());
		listOfResultadoEsperado = resultadoEsperadoBC.findAll();
		assertEquals(0, listOfResultadoEsperado.size());
	}
	
	@Test
	public void testUpdate() {
		// modifique para inserir dados conforme o construtor
		ResultadoEsperadoEntity resultadoEsperado = new ResultadoEsperadoEntity("titulo","descricao",EnumVersaoCertics.V_1_0,new AreaCompetenciaEntity());
		resultadoEsperadoBC.insert(resultadoEsperado);
		
		List<ResultadoEsperadoEntity> listOfResultadoEsperado = resultadoEsperadoBC.findAll();
		ResultadoEsperadoEntity resultadoEsperado2 = (ResultadoEsperadoEntity)listOfResultadoEsperado.get(0);
		assertNotNull(listOfResultadoEsperado);

		// alterar para tratar uma propriedade existente na Entidade ResultadoEsperado
		// resultadoEsperado2.setUmaPropriedade("novo valor");
		resultadoEsperadoBC.update(resultadoEsperado2);
		
		listOfResultadoEsperado = resultadoEsperadoBC.findAll();
		ResultadoEsperado resultadoEsperado3 = (ResultadoEsperado)listOfResultadoEsperado.get(0);
		
		// alterar para tratar uma propriedade existente na Entidade ResultadoEsperado
		assertEquals("novo valor", resultadoEsperado3.getVersaoCertics());
	}

}