package vinicius.ferneda.tcc.certics.domain;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_CONJUNTO_EVIDENCIAS")
@SequenceGenerator(name="CEV_ID", sequenceName="CEV_ID")
@NamedQueries({
    @NamedQuery(name = "ConjuntoEvidenciasEntity.findById", query = "SELECT obj FROM ConjuntoEvidenciasEntity obj WHERE obj.id = :id")
})
public class ConjuntoEvidenciasEntity extends ConjuntoEvidencias {

	private static final long serialVersionUID = 1L;
	
	public ConjuntoEvidenciasEntity(){
	}
	
	public ConjuntoEvidenciasEntity(String comentario, ResultadoEsperadoEntity resultadoEsperado) {
		setComentario(comentario);
		setResultadoEsperado(resultadoEsperado);
	}
	
}
