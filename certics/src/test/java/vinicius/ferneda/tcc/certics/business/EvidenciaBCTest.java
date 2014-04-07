

package vinicius.ferneda.tcc.certics.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import vinicius.ferneda.tcc.certics.domain.Evidencia;
import vinicius.ferneda.tcc.certics.domain.RespostaEvidencia;
import br.gov.frameworkdemoiselle.junit.DemoiselleRunner;

@RunWith(DemoiselleRunner.class)
public class EvidenciaBCTest {

    @Inject
	private EvidenciaBC evidenciaBC;
	
	@Before
	public void before() {
		for (Evidencia evidencia : evidenciaBC.findAll()) {
			evidenciaBC.delete(evidencia.getId());
		}
	}	
	
	
	@Test
	public void testInsert() {
				
		// modifique para inserir dados conforme o construtor
		Evidencia evidencia = new Evidencia("nome","descricao",new RespostaEvidencia());
		evidenciaBC.insert(evidencia);
		List<Evidencia> listOfEvidencia = evidenciaBC.findAll();
		assertNotNull(listOfEvidencia);
		assertEquals(1, listOfEvidencia.size());
	}	
	
	@Test
	public void testDelete() {
		
		// modifique para inserir dados conforme o construtor
		Evidencia evidencia = new Evidencia("nome","descricao",new RespostaEvidencia());
		evidenciaBC.insert(evidencia);
		
		List<Evidencia> listOfEvidencia = evidenciaBC.findAll();
		assertNotNull(listOfEvidencia);
		assertEquals(1, listOfEvidencia.size());
		
		evidenciaBC.delete(evidencia.getId());
		listOfEvidencia = evidenciaBC.findAll();
		assertEquals(0, listOfEvidencia.size());
	}
	
	@Test
	public void testUpdate() {
		// modifique para inserir dados conforme o construtor
		Evidencia evidencia = new Evidencia("nome","descricao",new RespostaEvidencia());
		evidenciaBC.insert(evidencia);
		
		List<Evidencia> listOfEvidencia = evidenciaBC.findAll();
		Evidencia evidencia2 = (Evidencia)listOfEvidencia.get(0);
		assertNotNull(listOfEvidencia);

		// alterar para tratar uma propriedade existente na Entidade Evidencia
		// evidencia2.setUmaPropriedade("novo valor");
		evidenciaBC.update(evidencia2);
		
		listOfEvidencia = evidenciaBC.findAll();
		Evidencia evidencia3 = (Evidencia)listOfEvidencia.get(0);
		
		// alterar para tratar uma propriedade existente na Entidade Evidencia
		// assertEquals("novo valor", evidencia3.getUmaPropriedade());
	}

}