package vinicius.ferneda.tcc.certics.domain;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_LICAO_APRENDIDA")
@SequenceGenerator(name="LIA_ID", sequenceName="SEQ_LIA_ID", allocationSize=1)
@NamedQueries({
    @NamedQuery(name="LicaoAprendidaEntity.findById", query="SELECT obj FROM LicaoAprendidaEntity obj WHERE obj.id = :id")
})
public class LicaoAprendidaEntity extends LicaoAprendida {

	private static final long serialVersionUID = 1L;
	
	public LicaoAprendidaEntity(){
	}
	
	public LicaoAprendidaEntity(String pontosPositivos, String pontosNegativos, String melhoria, AvaliacaoEntity avaliacao) {
		setPontosPositivos(pontosPositivos);
		setPontosNegativos(pontosNegativos);
		setMelhoria(melhoria);
		setAvaliacao(avaliacao);
	}
	
}
