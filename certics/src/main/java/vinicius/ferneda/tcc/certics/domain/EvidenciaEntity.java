package vinicius.ferneda.tcc.certics.domain;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_EVIDENCIA")
@SequenceGenerator(name="EVI_ID", sequenceName="EVI_ID", allocationSize=1)
@NamedQueries({
    @NamedQuery(name = "EvidenciaEntity.findById", query = "SELECT obj FROM EvidenciaEntity obj WHERE obj.id = :id")
})
public class EvidenciaEntity extends Evidencia {

	private static final long serialVersionUID = 1L;
	
	public EvidenciaEntity(){
	}
	
	public EvidenciaEntity(String nome, String descricao) {
		setNome(nome);
		setDescricao(descricao);
	}
}
