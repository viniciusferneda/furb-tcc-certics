

package vinicius.ferneda.tcc.certics.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import vinicius.ferneda.tcc.certics.domain.Evidencia;
import vinicius.ferneda.tcc.certics.domain.EvidenciaEntity;
import br.gov.frameworkdemoiselle.junit.DemoiselleRunner;

@RunWith(DemoiselleRunner.class)
public class EvidenciaBCTest {

    @Inject
	private EvidenciaEntityBC evidenciaEntityBC;
	
	@Before
	public void before() {
		for (Evidencia evidencia : evidenciaEntityBC.findAll()) {
			evidenciaEntityBC.delete(evidencia.getId());
		}
	}	
	
	
	@Test
	public void testInsert() {
				
		// modifique para inserir dados conforme o construtor
		EvidenciaEntity evidencia = new EvidenciaEntity("nome","descricao");
		evidenciaEntityBC.insert(evidencia);
		List<EvidenciaEntity> listOfEvidencia = evidenciaEntityBC.findAll();
		assertNotNull(listOfEvidencia);
		assertEquals(1, listOfEvidencia.size());
	}	
	
	@Test
	public void testDelete() {
		
		// modifique para inserir dados conforme o construtor
		EvidenciaEntity evidencia = new EvidenciaEntity("nome","descricao");
		evidenciaEntityBC.insert(evidencia);
		
		List<EvidenciaEntity> listOfEvidencia = evidenciaEntityBC.findAll();
		assertNotNull(listOfEvidencia);
		assertEquals(1, listOfEvidencia.size());
		
		evidenciaEntityBC.delete(evidencia.getId());
		listOfEvidencia = evidenciaEntityBC.findAll();
		assertEquals(0, listOfEvidencia.size());
	}
	
	@Test
	public void testUpdate() {
		// modifique para inserir dados conforme o construtor
		EvidenciaEntity evidencia = new EvidenciaEntity("nome","descricao");
		evidenciaEntityBC.insert(evidencia);
		
		List<EvidenciaEntity> listOfEvidencia = evidenciaEntityBC.findAll();
		EvidenciaEntity evidencia2 = (EvidenciaEntity)listOfEvidencia.get(0);
		assertNotNull(listOfEvidencia);

		// alterar para tratar uma propriedade existente na Entidade Evidencia
		// evidencia2.setUmaPropriedade("novo valor");
		evidenciaEntityBC.update(evidencia2);
		
		listOfEvidencia = evidenciaEntityBC.findAll();
		Evidencia evidencia3 = (Evidencia)listOfEvidencia.get(0);
		
		// alterar para tratar uma propriedade existente na Entidade Evidencia
		assertEquals("novo valor", evidencia3.getNome());
	}

}