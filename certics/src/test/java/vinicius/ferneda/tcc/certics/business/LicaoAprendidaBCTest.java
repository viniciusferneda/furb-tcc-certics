

package vinicius.ferneda.tcc.certics.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import vinicius.ferneda.tcc.certics.domain.AvaliacaoEntity;
import vinicius.ferneda.tcc.certics.domain.LicaoAprendida;
import vinicius.ferneda.tcc.certics.domain.LicaoAprendidaEntity;
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
		LicaoAprendidaEntity licaoAprendida = new LicaoAprendidaEntity("pontosPositivos","pontosNegativos","melhoria",new AvaliacaoEntity());
		licaoAprendidaBC.insert(licaoAprendida);
		List<LicaoAprendidaEntity> listOfLicaoAprendida = licaoAprendidaBC.findAll();
		assertNotNull(listOfLicaoAprendida);
		assertEquals(1, listOfLicaoAprendida.size());
	}	
	
	@Test
	public void testDelete() {
		
		// modifique para inserir dados conforme o construtor
		LicaoAprendidaEntity licaoAprendida = new LicaoAprendidaEntity("pontosPositivos","pontosNegativos","melhoria",new AvaliacaoEntity());
		licaoAprendidaBC.insert(licaoAprendida);
		
		List<LicaoAprendidaEntity> listOfLicaoAprendida = licaoAprendidaBC.findAll();
		assertNotNull(listOfLicaoAprendida);
		assertEquals(1, listOfLicaoAprendida.size());
		
		licaoAprendidaBC.delete(licaoAprendida.getId());
		listOfLicaoAprendida = licaoAprendidaBC.findAll();
		assertEquals(0, listOfLicaoAprendida.size());
	}
	
	@Test
	public void testUpdate() {
		// modifique para inserir dados conforme o construtor
		LicaoAprendidaEntity licaoAprendida = new LicaoAprendidaEntity("pontosPositivos","pontosNegativos","melhoria",new AvaliacaoEntity());
		licaoAprendidaBC.insert(licaoAprendida);
		
		List<LicaoAprendidaEntity> listOfLicaoAprendida = licaoAprendidaBC.findAll();
		LicaoAprendidaEntity licaoAprendida2 = (LicaoAprendidaEntity)listOfLicaoAprendida.get(0);
		assertNotNull(listOfLicaoAprendida);

		// alterar para tratar uma propriedade existente na Entidade LicaoAprendida
		// licaoAprendida2.setUmaPropriedade("novo valor");
		licaoAprendidaBC.update(licaoAprendida2);
		
		listOfLicaoAprendida = licaoAprendidaBC.findAll();
		LicaoAprendida licaoAprendida3 = (LicaoAprendida)listOfLicaoAprendida.get(0);
		
		// alterar para tratar uma propriedade existente na Entidade LicaoAprendida
		assertEquals("novo valor", licaoAprendida3.getAvaliacao());
	}

}