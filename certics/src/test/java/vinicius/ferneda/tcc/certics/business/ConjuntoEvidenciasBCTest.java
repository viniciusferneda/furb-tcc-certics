

package vinicius.ferneda.tcc.certics.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import vinicius.ferneda.tcc.certics.domain.ConjuntoEvidencias;
import vinicius.ferneda.tcc.certics.domain.ConjuntoEvidenciasEntity;
import vinicius.ferneda.tcc.certics.domain.ResultadoEsperadoEntity;
import br.gov.frameworkdemoiselle.junit.DemoiselleRunner;

@RunWith(DemoiselleRunner.class)
public class ConjuntoEvidenciasBCTest {

    @Inject
	private ConjuntoEvidenciasBC conjuntoEvidenciasBC;
	
	@Before
	public void before() {
		for (ConjuntoEvidencias conjuntoEvidencias : conjuntoEvidenciasBC.findAll()) {
			conjuntoEvidenciasBC.delete(conjuntoEvidencias.getId());
		}
	}	
	
	@Test
	public void testInsert() {
				
		// modifique para inserir dados conforme o construtor
		ConjuntoEvidencias conjuntoEvidencias = new ConjuntoEvidenciasEntity("comentario",new ResultadoEsperadoEntity());
		conjuntoEvidenciasBC.insert(conjuntoEvidencias);
		List<ConjuntoEvidencias> listOfConjuntoEvidencias = conjuntoEvidenciasBC.findAll();
		assertNotNull(listOfConjuntoEvidencias);
		assertEquals(1, listOfConjuntoEvidencias.size());
	}	
	
	@Test
	public void testDelete() {
		
		// modifique para inserir dados conforme o construtor
		ConjuntoEvidencias conjuntoEvidencias = new ConjuntoEvidenciasEntity("comentario",new ResultadoEsperadoEntity());
		conjuntoEvidenciasBC.insert(conjuntoEvidencias);
		
		List<ConjuntoEvidencias> listOfConjuntoEvidencias = conjuntoEvidenciasBC.findAll();
		assertNotNull(listOfConjuntoEvidencias);
		assertEquals(1, listOfConjuntoEvidencias.size());
		
		conjuntoEvidenciasBC.delete(conjuntoEvidencias.getId());
		listOfConjuntoEvidencias = conjuntoEvidenciasBC.findAll();
		assertEquals(0, listOfConjuntoEvidencias.size());
	}
	
	@Test
	public void testUpdate() {
		// modifique para inserir dados conforme o construtor
		ConjuntoEvidencias conjuntoEvidencias = new ConjuntoEvidenciasEntity("comentario",new ResultadoEsperadoEntity());
		conjuntoEvidenciasBC.insert(conjuntoEvidencias);
		
		List<ConjuntoEvidencias> listOfConjuntoEvidencias = conjuntoEvidenciasBC.findAll();
		ConjuntoEvidencias conjuntoEvidencias2 = (ConjuntoEvidencias)listOfConjuntoEvidencias.get(0);
		assertNotNull(listOfConjuntoEvidencias);

		// alterar para tratar uma propriedade existente na Entidade ConjuntoEvidencias
		// conjuntoEvidencias2.setUmaPropriedade("novo valor");
		conjuntoEvidenciasBC.update(conjuntoEvidencias2);
		
		listOfConjuntoEvidencias = conjuntoEvidenciasBC.findAll();
		ConjuntoEvidencias conjuntoEvidencias3 = (ConjuntoEvidencias)listOfConjuntoEvidencias.get(0);
		
		// alterar para tratar uma propriedade existente na Entidade ConjuntoEvidencias
		assertEquals("novo valor", conjuntoEvidencias3.getResultadoEsperado());
	}

}