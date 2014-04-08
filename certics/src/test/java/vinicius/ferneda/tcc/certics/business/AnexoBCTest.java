

package vinicius.ferneda.tcc.certics.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import vinicius.ferneda.tcc.certics.domain.Anexo;
import vinicius.ferneda.tcc.certics.domain.Evidencia;
import br.gov.frameworkdemoiselle.junit.DemoiselleRunner;

@RunWith(DemoiselleRunner.class)
public class AnexoBCTest {

    @Inject
	private AnexoBC anexoBC;
	
	@Before
	public void before() {
		for (Anexo anexo : anexoBC.findAll()) {
			anexoBC.delete(anexo.getId());
		}
	}	
	
	
	@Test
	public void testInsert() {
				
		// modifique para inserir dados conforme o construtor
		Anexo anexo = new Anexo(new Byte(""),new Evidencia());
		anexoBC.insert(anexo);
		List<Anexo> listOfAnexo = anexoBC.findAll();
		assertNotNull(listOfAnexo);
		assertEquals(1, listOfAnexo.size());
	}	
	
	@Test
	public void testDelete() {
		
		// modifique para inserir dados conforme o construtor
		Anexo anexo = new Anexo(new Byte(""),new Evidencia());
		anexoBC.insert(anexo);
		
		List<Anexo> listOfAnexo = anexoBC.findAll();
		assertNotNull(listOfAnexo);
		assertEquals(1, listOfAnexo.size());
		
		anexoBC.delete(anexo.getId());
		listOfAnexo = anexoBC.findAll();
		assertEquals(0, listOfAnexo.size());
	}
	
	@Test
	public void testUpdate() {
		// modifique para inserir dados conforme o construtor
		Anexo anexo = new Anexo(new Byte(""),new Evidencia());
		anexoBC.insert(anexo);
		
		List<Anexo> listOfAnexo = anexoBC.findAll();
		Anexo anexo2 = (Anexo)listOfAnexo.get(0);
		assertNotNull(listOfAnexo);

		// alterar para tratar uma propriedade existente na Entidade Anexo
		// anexo2.setUmaPropriedade("novo valor");
		anexoBC.update(anexo2);
		
		listOfAnexo = anexoBC.findAll();
		Anexo anexo3 = (Anexo)listOfAnexo.get(0);
		
		// alterar para tratar uma propriedade existente na Entidade Anexo
		assertEquals("novo valor", anexo3.getArquivo());
	}

}