
package vinicius.ferneda.tcc.certics.business;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import vinicius.ferneda.tcc.certics.domain.AvaliacaoEntity;
import vinicius.ferneda.tcc.certics.domain.ConjuntoEvidenciasEntity;
import vinicius.ferneda.tcc.certics.domain.ResultadoEsperadoEntity;
import vinicius.ferneda.tcc.certics.persistence.ConjuntoEvidenciasDAO;
import vinicius.ferneda.tcc.certics.persistence.ResultadoEsperadoDAO;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

@BusinessController
public class ConjuntoEvidenciasBC extends DelegateCrud<ConjuntoEvidenciasEntity, Long, ConjuntoEvidenciasDAO> {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ResultadoEsperadoDAO resultadoEsperadoDAO;
	
	public void criarConjuntoEvidencias(AvaliacaoEntity avaliacaoEntity){
		List<ResultadoEsperadoEntity> lResultadosEsperados = this.resultadoEsperadoDAO.findByVersaoCertics(avaliacaoEntity.getVersaoCertics().getId());
		List<ConjuntoEvidenciasEntity> lConjuntoEvidencias = new ArrayList<ConjuntoEvidenciasEntity>();
		
		for (ResultadoEsperadoEntity resultadoEsperadoEntity : lResultadosEsperados) {
			ConjuntoEvidenciasEntity conjuntoEvidencias = new ConjuntoEvidenciasEntity(avaliacaoEntity, resultadoEsperadoEntity);
			insert(conjuntoEvidencias);
			lConjuntoEvidencias.add(conjuntoEvidencias);
		}
	}
	
}
