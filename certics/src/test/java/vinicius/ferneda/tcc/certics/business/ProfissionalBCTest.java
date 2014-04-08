

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
import vinicius.ferneda.tcc.certics.domain.Endereco;
import vinicius.ferneda.tcc.certics.domain.OrganizacaoSolicitante;
import vinicius.ferneda.tcc.certics.domain.Profissional;
import br.gov.frameworkdemoiselle.junit.DemoiselleRunner;

@RunWith(DemoiselleRunner.class)
public class ProfissionalBCTest {

    @Inject
	private ProfissionalBC profissionalBC;
	
	@Before
	public void before() {
		for (Profissional profissional : profissionalBC.findAll()) {
			profissionalBC.delete(profissional.getId());
		}
	}	
	
	
	@Test
	public void testInsert() {
				
		// modifique para inserir dados conforme o construtor
		Profissional profissional = new Profissional("vinculoAtual",Integer.valueOf(1),new OrganizacaoSolicitante(),"nome","cpf","rg",EnumSexo.MASCULINO,new Date(),"fone1","fone2",new Endereco());
		profissionalBC.insert(profissional);
		List<Profissional> listOfProfissional = profissionalBC.findAll();
		assertNotNull(listOfProfissional);
		assertEquals(1, listOfProfissional.size());
	}	
	
	@Test
	public void testDelete() {
		
		// modifique para inserir dados conforme o construtor
		Profissional profissional = new Profissional("vinculoAtual",Integer.valueOf(1),new OrganizacaoSolicitante(),"nome","cpf","rg",EnumSexo.MASCULINO,new Date(),"fone1","fone2",new Endereco());
		profissionalBC.insert(profissional);
		
		List<Profissional> listOfProfissional = profissionalBC.findAll();
		assertNotNull(listOfProfissional);
		assertEquals(1, listOfProfissional.size());
		
		profissionalBC.delete(profissional.getId());
		listOfProfissional = profissionalBC.findAll();
		assertEquals(0, listOfProfissional.size());
	}
	
	@Test
	public void testUpdate() {
		// modifique para inserir dados conforme o construtor
		Profissional profissional = new Profissional("vinculoAtual",Integer.valueOf(1),new OrganizacaoSolicitante(),"nome","cpf","rg",EnumSexo.MASCULINO,new Date(),"fone1","fone2",new Endereco());
		profissionalBC.insert(profissional);
		
		List<Profissional> listOfProfissional = profissionalBC.findAll();
		Profissional profissional2 = (Profissional)listOfProfissional.get(0);
		assertNotNull(listOfProfissional);

		// alterar para tratar uma propriedade existente na Entidade Profissional
		// profissional2.setUmaPropriedade("novo valor");
		profissionalBC.update(profissional2);
		
		listOfProfissional = profissionalBC.findAll();
		Profissional profissional3 = (Profissional)listOfProfissional.get(0);
		
		// alterar para tratar uma propriedade existente na Entidade Profissional
		assertEquals("novo valor", profissional3.getCpf());
	}

}