

package vinicius.ferneda.tcc.certics.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import vinicius.ferneda.tcc.certics.domain.EvidenciaProfissional;
import vinicius.ferneda.tcc.certics.domain.EvidenciaProfissionalEntity;
import vinicius.ferneda.tcc.certics.domain.ProfissionalEntity;
import vinicius.ferneda.tcc.certics.domain.RespostaEvidenciaEntity;
import br.gov.frameworkdemoiselle.junit.DemoiselleRunner;

@RunWith(DemoiselleRunner.class)
public class EvidenciaProfissionalBCTest {

    @Inject
	private EvidenciaProfissionalBC evidenciaProfissionalBC;
	
	@Before
	public void before() {
		for (EvidenciaProfissional evidenciaProfissional : evidenciaProfissionalBC.findAll()) {
			evidenciaProfissionalBC.delete(evidenciaProfissional.getId());
		}
	}	
	
	
	@Test
	public void testInsert() {
				
		// modifique para inserir dados conforme o construtor
		EvidenciaProfissional evidenciaProfissional = new EvidenciaProfissionalEntity(Integer.valueOf(1),"envolvimento",new RespostaEvidenciaEntity(),new ProfissionalEntity());
		evidenciaProfissionalBC.insert(evidenciaProfissional);
		List<EvidenciaProfissional> listOfEvidenciaProfissional = evidenciaProfissionalBC.findAll();
		assertNotNull(listOfEvidenciaProfissional);
		assertEquals(1, listOfEvidenciaProfissional.size());
	}	
	
	@Test
	public void testDelete() {
		
		// modifique para inserir dados conforme o construtor
		EvidenciaProfissional evidenciaProfissional = new EvidenciaProfissionalEntity(Integer.valueOf(1),"envolvimento",new RespostaEvidenciaEntity(),new ProfissionalEntity());
		evidenciaProfissionalBC.insert(evidenciaProfissional);
		
		List<EvidenciaProfissional> listOfEvidenciaProfissional = evidenciaProfissionalBC.findAll();
		assertNotNull(listOfEvidenciaProfissional);
		assertEquals(1, listOfEvidenciaProfissional.size());
		
		evidenciaProfissionalBC.delete(evidenciaProfissional.getId());
		listOfEvidenciaProfissional = evidenciaProfissionalBC.findAll();
		assertEquals(0, listOfEvidenciaProfissional.size());
	}
	
	@Test
	public void testUpdate() {
		// modifique para inserir dados conforme o construtor
		EvidenciaProfissional evidenciaProfissional = new EvidenciaProfissionalEntity(Integer.valueOf(1),"envolvimento",new RespostaEvidenciaEntity(),new ProfissionalEntity());
		evidenciaProfissionalBC.insert(evidenciaProfissional);
		
		List<EvidenciaProfissional> listOfEvidenciaProfissional = evidenciaProfissionalBC.findAll();
		EvidenciaProfissional evidenciaProfissional2 = (EvidenciaProfissional)listOfEvidenciaProfissional.get(0);
		assertNotNull(listOfEvidenciaProfissional);

		// alterar para tratar uma propriedade existente na Entidade EvidenciaProfissional
		// evidenciaProfissional2.setUmaPropriedade("novo valor");
		evidenciaProfissionalBC.update(evidenciaProfissional2);
		
		listOfEvidenciaProfissional = evidenciaProfissionalBC.findAll();
		EvidenciaProfissional evidenciaProfissional3 = (EvidenciaProfissional)listOfEvidenciaProfissional.get(0);
		
		// alterar para tratar uma propriedade existente na Entidade EvidenciaProfissional
		assertEquals("novo valor", evidenciaProfissional3.getProfissional());
	}

}