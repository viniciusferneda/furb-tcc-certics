package vinicius.ferneda.tcc.certics.domain;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import vinicius.ferneda.tcc.certics.constant.EnumPontuacaoEvidencia;

@Entity
@Table(name="TB_CONJUNTO_EVIDENCIAS")
@SequenceGenerator(name="CEV_ID", sequenceName="SEQ_CEV_ID", allocationSize=1)
@NamedQueries({
    @NamedQuery(name="ConjuntoEvidenciasEntity.findById", 
    		query="SELECT obj "
    				+ " FROM ConjuntoEvidenciasEntity obj "
    				+ " WHERE obj.id = :id"),
    				
    @NamedQuery(name="ConjuntoEvidenciasEntity.findByResultadoEsperadoID",
    		query="SELECT obj "
    				+ " FROM ConjuntoEvidenciasEntity obj "
    				+ " INNER JOIN obj.resultadoEsperado res "
    				+ " WHERE res.id = :resultadoEsperadoID"
    				+ "		AND obj.avaliacao.id = :avaliacaoID"),
    
    @NamedQuery(name="ConjuntoEvidenciasEntity.findByAvaliacaoID",
			query="SELECT obj "
					+ " FROM ConjuntoEvidenciasEntity obj "
					+ " INNER JOIN obj.avaliacao ava "
					+ " WHERE ava.id = :avaliacaoID")
})
public class ConjuntoEvidenciasEntity extends ConjuntoEvidencias {

	private static final long serialVersionUID = 1L;
	
	public ConjuntoEvidenciasEntity(){
	}
	
	public ConjuntoEvidenciasEntity(EnumPontuacaoEvidencia pontuacao, String comentario, ResultadoEsperadoEntity resultadoEsperado) {
		setPontuacao(pontuacao);
		setComentario(comentario);
		setResultadoEsperado(resultadoEsperado);
	}

	public ConjuntoEvidenciasEntity(AvaliacaoEntity avaliacaoEntity, ResultadoEsperadoEntity resultadoEsperadoEntity) {
		setAvaliacao(avaliacaoEntity);
		setResultadoEsperado(resultadoEsperadoEntity);
	}

}
