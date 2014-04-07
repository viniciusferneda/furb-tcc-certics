

package vinicius.ferneda.tcc.certics.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import vinicius.ferneda.tcc.certics.domain.Avaliacao;
import vinicius.ferneda.tcc.certics.domain.LicaoAprendida;
import br.gov.frameworkdemoiselle.junit.DemoiselleRunner;

@RunWith(DemoiselleRunner.class)
public class LicaoAprendidaBCTest {

    @Inject
	private LicaoAprendidaBC licaoAprendidaBC;
	
	@Before
	public void before() {
		for (LicaoAprendida licaoAprendida : licaoAprendidaBC.findAll()) {
			licaoAprendidaBC.delete(licaoAprendida.getId());
		}
	}	
	
	
	@Test
	public void testInsert() {
				
		// modifique para inserir dados conforme o construtor
		LicaoAprendida licaoAprendida = new LicaoAprendida("pontosPositivos","pontosNegativos","melhoria",new Avaliacao());
		licaoAprendidaBC.insert(licaoAprendida);
		List<LicaoAprendida> listOfLicaoAprendida = licaoAprendidaBC.findAll();
		assertNotNull(listOfLicaoAprendida);
		assertEquals(1, listOfLicaoAprendida.size());
	}	
	
	@Test
	public void testDelete() {
		
		// modifique para inserir dados conforme o construtor
		LicaoAprendida licaoAprendida = new LicaoAprendida("pontosPositivos","pontosNegativos","melhoria",new Avaliacao());
		licaoAprendidaBC.insert(licaoAprendida);
		
		List<LicaoAprendida> listOfLicaoAprendida = licaoAprendidaBC.findAll();
		assertNotNull(listOfLicaoAprendida);
		assertEquals(1, listOfLicaoAprendida.size());
		
		licaoAprendidaBC.delete(licaoAprendida.getId());
		listOfLicaoAprendida = licaoAprendidaBC.findAll();
		assertEquals(0, listOfLicaoAprendida.size());
	}
	
	@Test
	public void testUpdate() {
		// modifique para inserir dados conforme o construtor
		LicaoAprendida licaoAprendida = new LicaoAprendida("pontosPositivos","pontosNegativos","melhoria",new Avaliacao());
		licaoAprendidaBC.insert(licaoAprendida);
		
		List<LicaoAprendida> listOfLicaoAprendida = licaoAprendidaBC.findAll();
		LicaoAprendida licaoAprendida2 = (LicaoAprendida)listOfLicaoAprendida.get(0);
		assertNotNull(listOfLicaoAprendida);

		// alterar para tratar uma propriedade existente na Entidade LicaoAprendida
		// licaoAprendida2.setUmaPropriedade("novo valor");
		licaoAprendidaBC.update(licaoAprendida2);
		
		listOfLicaoAprendida = licaoAprendidaBC.findAll();
		LicaoAprendida licaoAprendida3 = (LicaoAprendida)listOfLicaoAprendida.get(0);
		
		// alterar para tratar uma propriedade existente na Entidade LicaoAprendida
		// assertEquals("novo valor", licaoAprendida3.getUmaPropriedade());
	}

}