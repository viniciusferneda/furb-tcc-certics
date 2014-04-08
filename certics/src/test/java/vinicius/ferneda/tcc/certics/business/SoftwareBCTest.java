

package vinicius.ferneda.tcc.certics.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import vinicius.ferneda.tcc.certics.domain.Software;
import br.gov.frameworkdemoiselle.junit.DemoiselleRunner;

@RunWith(DemoiselleRunner.class)
public class SoftwareBCTest {

    @Inject
	private SoftwareBC softwareBC;
	
	@Before
	public void before() {
		for (Software software : softwareBC.findAll()) {
			softwareBC.delete(software.getId());
		}
	}	
	
	
	@Test
	public void testInsert() {
				
		// modifique para inserir dados conforme o construtor
		Software software = new Software("nome","descricao","historico","tecnologias","aspectInovador","release",new Date(),new Date());
		softwareBC.insert(software);
		List<Software> listOfSoftware = softwareBC.findAll();
		assertNotNull(listOfSoftware);
		assertEquals(1, listOfSoftware.size());
	}	
	
	@Test
	public void testDelete() {
		
		// modifique para inserir dados conforme o construtor
		Software software = new Software("nome","descricao","historico","tecnologias","aspectInovador","release",new Date(),new Date());
		softwareBC.insert(software);
		
		List<Software> listOfSoftware = softwareBC.findAll();
		assertNotNull(listOfSoftware);
		assertEquals(1, listOfSoftware.size());
		
		softwareBC.delete(software.getId());
		listOfSoftware = softwareBC.findAll();
		assertEquals(0, listOfSoftware.size());
	}
	
	@Test
	public void testUpdate() {
		// modifique para inserir dados conforme o construtor
		Software software = new Software("nome","descricao","historico","tecnologias","aspectInovador","release",new Date(),new Date());
		softwareBC.insert(software);
		
		List<Software> listOfSoftware = softwareBC.findAll();
		Software software2 = (Software)listOfSoftware.get(0);
		assertNotNull(listOfSoftware);

		// alterar para tratar uma propriedade existente na Entidade Software
		// software2.setUmaPropriedade("novo valor");
		softwareBC.update(software2);
		
		listOfSoftware = softwareBC.findAll();
		Software software3 = (Software)listOfSoftware.get(0);
		
		// alterar para tratar uma propriedade existente na Entidade Software
		assertEquals("novo valor", software3.getNome());
	}

}