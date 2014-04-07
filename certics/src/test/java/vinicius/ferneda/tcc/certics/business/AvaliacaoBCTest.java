

package vinicius.ferneda.tcc.certics.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import vinicius.ferneda.tcc.certics.constant.EnumPontuacaoAvaliacao;
import vinicius.ferneda.tcc.certics.constant.EnumVersaoCertics;
import vinicius.ferneda.tcc.certics.domain.Avaliacao;
import vinicius.ferneda.tcc.certics.domain.Avaliador;
import vinicius.ferneda.tcc.certics.domain.Software;
import br.gov.frameworkdemoiselle.junit.DemoiselleRunner;

@RunWith(DemoiselleRunner.class)
public class AvaliacaoBCTest {

    @Inject
	private AvaliacaoBC avaliacaoBC;
	
	@Before
	public void before() {
		for (Avaliacao avaliacao : avaliacaoBC.findAll()) {
			avaliacaoBC.delete(avaliacao.getId());
		}
	}	
	
	
	@Test
	public void testInsert() {
				
		// modifique para inserir dados conforme o construtor
		Avaliacao avaliacao = new Avaliacao(EnumVersaoCertics.V_1_0,EnumPontuacaoAvaliacao.REPROVADA,new Date(),new Software(),new Avaliador());
		avaliacaoBC.insert(avaliacao);
		List<Avaliacao> listOfAvaliacao = avaliacaoBC.findAll();
		assertNotNull(listOfAvaliacao);
		assertEquals(1, listOfAvaliacao.size());
	}	
	
	@Test
	public void testDelete() {
		
		// modifique para inserir dados conforme o construtor
		Avaliacao avaliacao = new Avaliacao(EnumVersaoCertics.V_1_0,EnumPontuacaoAvaliacao.REPROVADA,new Date(),new Software(),new Avaliador());
		avaliacaoBC.insert(avaliacao);
		
		List<Avaliacao> listOfAvaliacao = avaliacaoBC.findAll();
		assertNotNull(listOfAvaliacao);
		assertEquals(1, listOfAvaliacao.size());
		
		avaliacaoBC.delete(avaliacao.getId());
		listOfAvaliacao = avaliacaoBC.findAll();
		assertEquals(0, listOfAvaliacao.size());
	}
	
	@Test
	public void testUpdate() {
		// modifique para inserir dados conforme o construtor
		Avaliacao avaliacao = new Avaliacao(EnumVersaoCertics.V_1_0,EnumPontuacaoAvaliacao.REPROVADA,new Date(),new Software(),new Avaliador());
		avaliacaoBC.insert(avaliacao);
		
		List<Avaliacao> listOfAvaliacao = avaliacaoBC.findAll();
		Avaliacao avaliacao2 = (Avaliacao)listOfAvaliacao.get(0);
		assertNotNull(listOfAvaliacao);

		// alterar para tratar uma propriedade existente na Entidade Avaliacao
		// avaliacao2.setUmaPropriedade("novo valor");
		avaliacaoBC.update(avaliacao2);
		
		listOfAvaliacao = avaliacaoBC.findAll();
		Avaliacao avaliacao3 = (Avaliacao)listOfAvaliacao.get(0);
		
		// alterar para tratar uma propriedade existente na Entidade Avaliacao
		// assertEquals("novo valor", avaliacao3.getUmaPropriedade());
	}

}