

package vinicius.ferneda.tcc.certics.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import vinicius.ferneda.tcc.certics.constant.EnumVersaoCertics;
import vinicius.ferneda.tcc.certics.domain.AreaCompetencia;
import br.gov.frameworkdemoiselle.junit.DemoiselleRunner;

@RunWith(DemoiselleRunner.class)
public class AreaCompetenciaBCTest {

    @Inject
	private AreaCompetenciaBC areaCompetenciaBC;
	
	@Before
	public void before() {
		for (AreaCompetencia areaCompetencia : areaCompetenciaBC.findAll()) {
			areaCompetenciaBC.delete(areaCompetencia.getId());
		}
	}	
	
	
	@Test
	public void testInsert() {
				
		// modifique para inserir dados conforme o construtor
		AreaCompetencia areaCompetencia = new AreaCompetencia("titulo","perguntaChave","descricao",EnumVersaoCertics.V_1_0);
		areaCompetenciaBC.insert(areaCompetencia);
		List<AreaCompetencia> listOfAreaCompetencia = areaCompetenciaBC.findAll();
		assertNotNull(listOfAreaCompetencia);
		assertEquals(1, listOfAreaCompetencia.size());
	}	
	
	@Test
	public void testDelete() {
		
		// modifique para inserir dados conforme o construtor
		AreaCompetencia areaCompetencia = new AreaCompetencia("titulo","perguntaChave","descricao",EnumVersaoCertics.V_1_0);
		areaCompetenciaBC.insert(areaCompetencia);
		
		List<AreaCompetencia> listOfAreaCompetencia = areaCompetenciaBC.findAll();
		assertNotNull(listOfAreaCompetencia);
		assertEquals(1, listOfAreaCompetencia.size());
		
		areaCompetenciaBC.delete(areaCompetencia.getId());
		listOfAreaCompetencia = areaCompetenciaBC.findAll();
		assertEquals(0, listOfAreaCompetencia.size());
	}
	
	@Test
	public void testUpdate() {
		// modifique para inserir dados conforme o construtor
		AreaCompetencia areaCompetencia = new AreaCompetencia("titulo","perguntaChave","descricao",EnumVersaoCertics.V_1_0);
		areaCompetenciaBC.insert(areaCompetencia);
		
		List<AreaCompetencia> listOfAreaCompetencia = areaCompetenciaBC.findAll();
		AreaCompetencia areaCompetencia2 = (AreaCompetencia)listOfAreaCompetencia.get(0);
		assertNotNull(listOfAreaCompetencia);

		// alterar para tratar uma propriedade existente na Entidade AreaCompetencia
		// areaCompetencia2.setUmaPropriedade("novo valor");
		areaCompetenciaBC.update(areaCompetencia2);
		
		listOfAreaCompetencia = areaCompetenciaBC.findAll();
		AreaCompetencia areaCompetencia3 = (AreaCompetencia)listOfAreaCompetencia.get(0);
		
		// alterar para tratar uma propriedade existente na Entidade AreaCompetencia
		// assertEquals("novo valor", areaCompetencia3.getUmaPropriedade());
	}

}