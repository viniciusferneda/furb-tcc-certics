

package vinicius.ferneda.tcc.certics.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import vinicius.ferneda.tcc.certics.domain.OrganizacaoSolicitante;
import br.gov.frameworkdemoiselle.junit.DemoiselleRunner;

@RunWith(DemoiselleRunner.class)
public class OrganizacaoSolicitanteBCTest {

    @Inject
	private OrganizacaoSolicitanteBC organizacaoSolicitanteBC;
	
	@Before
	public void before() {
		for (OrganizacaoSolicitante organizacaoSolicitante : organizacaoSolicitanteBC.findAll()) {
			organizacaoSolicitanteBC.delete(organizacaoSolicitante.getId());
		}
	}	
	
	
	@Test
	public void testInsert() {
				
		// modifique para inserir dados conforme o construtor
		OrganizacaoSolicitante organizacaoSolicitante = new OrganizacaoSolicitante("nome","razaoSocial","cnpj","fone1","fone2",null);
		organizacaoSolicitanteBC.insert(organizacaoSolicitante);
		List<OrganizacaoSolicitante> listOfOrganizacaoSolicitante = organizacaoSolicitanteBC.findAll();
		assertNotNull(listOfOrganizacaoSolicitante);
		assertEquals(1, listOfOrganizacaoSolicitante.size());
	}	
	
	@Test
	public void testDelete() {
		
		// modifique para inserir dados conforme o construtor
		OrganizacaoSolicitante organizacaoSolicitante = new OrganizacaoSolicitante("nome","razaoSocial","cnpj","fone1","fone2",null);
		organizacaoSolicitanteBC.insert(organizacaoSolicitante);
		
		List<OrganizacaoSolicitante> listOfOrganizacaoSolicitante = organizacaoSolicitanteBC.findAll();
		assertNotNull(listOfOrganizacaoSolicitante);
		assertEquals(1, listOfOrganizacaoSolicitante.size());
		
		organizacaoSolicitanteBC.delete(organizacaoSolicitante.getId());
		listOfOrganizacaoSolicitante = organizacaoSolicitanteBC.findAll();
		assertEquals(0, listOfOrganizacaoSolicitante.size());
	}
	
	@Test
	public void testUpdate() {
		// modifique para inserir dados conforme o construtor
		OrganizacaoSolicitante organizacaoSolicitante = new OrganizacaoSolicitante("nome","razaoSocial","cnpj","fone1","fone2",null);
		organizacaoSolicitanteBC.insert(organizacaoSolicitante);
		
		List<OrganizacaoSolicitante> listOfOrganizacaoSolicitante = organizacaoSolicitanteBC.findAll();
		OrganizacaoSolicitante organizacaoSolicitante2 = (OrganizacaoSolicitante)listOfOrganizacaoSolicitante.get(0);
		assertNotNull(listOfOrganizacaoSolicitante);

		// alterar para tratar uma propriedade existente na Entidade OrganizacaoSolicitante
		// organizacaoSolicitante2.setUmaPropriedade("novo valor");
		organizacaoSolicitanteBC.update(organizacaoSolicitante2);
		
		listOfOrganizacaoSolicitante = organizacaoSolicitanteBC.findAll();
		OrganizacaoSolicitante organizacaoSolicitante3 = (OrganizacaoSolicitante)listOfOrganizacaoSolicitante.get(0);
		
		// alterar para tratar uma propriedade existente na Entidade OrganizacaoSolicitante
		assertEquals("novo valor", organizacaoSolicitante3.getCnpj());
	}

}