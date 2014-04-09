

package vinicius.ferneda.tcc.certics.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import vinicius.ferneda.tcc.certics.constant.EnumSexo;
import vinicius.ferneda.tcc.certics.domain.Avaliador;
import vinicius.ferneda.tcc.certics.domain.AvaliadorEntity;
import vinicius.ferneda.tcc.certics.domain.Endereco;
import br.gov.frameworkdemoiselle.junit.DemoiselleRunner;

@RunWith(DemoiselleRunner.class)
public class AvaliadorBCTest {

    @Inject
	private AvaliadorBC avaliadorBC;
	
	@Before
	public void before() {
		for (Avaliador avaliador : avaliadorBC.findAll()) {
			avaliadorBC.delete(avaliador.getId());
		}
	}	
	
	
	@Test
	public void testInsert() {
				
		// modifique para inserir dados conforme o construtor
		AvaliadorEntity avaliador = new AvaliadorEntity("nome","cpf","rg",EnumSexo.MASCULINO,new Date(),"fone1","fone2",new Endereco());
		avaliadorBC.insert(avaliador);
		List<AvaliadorEntity> listOfAvaliador = avaliadorBC.findAll();
		assertNotNull(listOfAvaliador);
		assertEquals(1, listOfAvaliador.size());
	}	
	
	@Test
	public void testDelete() {
		
		// modifique para inserir dados conforme o construtor
		AvaliadorEntity avaliador = new AvaliadorEntity("nome","cpf","rg",EnumSexo.MASCULINO,new Date(),"fone1","fone2",new Endereco());
		avaliadorBC.insert(avaliador);
		
		List<AvaliadorEntity> listOfAvaliador = avaliadorBC.findAll();
		assertNotNull(listOfAvaliador);
		assertEquals(1, listOfAvaliador.size());
		
		avaliadorBC.delete(avaliador.getId());
		listOfAvaliador = avaliadorBC.findAll();
		assertEquals(0, listOfAvaliador.size());
	}
	
	@Test
	public void testUpdate() {
		// modifique para inserir dados conforme o construtor
		AvaliadorEntity avaliador = new AvaliadorEntity("nome","cpf","rg",EnumSexo.MASCULINO,new Date(),"fone1","fone2",new Endereco());
		avaliadorBC.insert(avaliador);
		
		List<AvaliadorEntity> listOfAvaliador = avaliadorBC.findAll();
		AvaliadorEntity avaliador2 = (AvaliadorEntity)listOfAvaliador.get(0);
		assertNotNull(listOfAvaliador);

		// alterar para tratar uma propriedade existente na Entidade Avaliador
		// avaliador2.setUmaPropriedade("novo valor");
		avaliadorBC.update(avaliador2);
		
		listOfAvaliador = avaliadorBC.findAll();
		Avaliador avaliador3 = (Avaliador)listOfAvaliador.get(0);
		
		// alterar para tratar uma propriedade existente na Entidade Avaliador
		assertEquals("novo valor", avaliador3.getCpf());
	}

}