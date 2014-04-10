package vinicius.ferneda.tcc.certics.domain;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import vinicius.ferneda.tcc.certics.constant.EnumVersaoCertics;

@Entity
@Table(name="TB_RESULTADO_ESPERADO")
@NamedQueries({
    @NamedQuery(name="ResultadoEsperadoEntity.findById", query="SELECT obj FROM ResultadoEsperadoEntity obj WHERE obj.id = :id")
})
public class ResultadoEsperadoEntity extends ResultadoEsperado {

	private static final long serialVersionUID = 1L;
	
	public ResultadoEsperadoEntity(){
	}
	
	public ResultadoEsperadoEntity(String titulo, String descricao, EnumVersaoCertics versaoCertics, AreaCompetenciaEntity areaCompetencia) {
		setTitulo(titulo);
		setDescricao(descricao);
		setVersaoCertics(versaoCertics);
		setAreaCompetencia(areaCompetencia);
	}
	
}
