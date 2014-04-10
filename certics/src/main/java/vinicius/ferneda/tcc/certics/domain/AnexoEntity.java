package vinicius.ferneda.tcc.certics.domain;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="TB_ANEXO")
@NamedQueries({
    @NamedQuery(name = "AnexoEntity.findById", query = "SELECT obj FROM AnexoEntity obj WHERE obj.id = :id")
})
public class AnexoEntity extends Anexo {

	private static final long serialVersionUID = 1L;
	
	public AnexoEntity(){
	}
	
	public AnexoEntity(Byte arquivo, EvidenciaEntity evidencia) {
		setArquivo(arquivo);
		setEvidencia(evidencia);
	}
	
}
