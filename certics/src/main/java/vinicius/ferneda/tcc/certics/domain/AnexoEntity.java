package vinicius.ferneda.tcc.certics.domain;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.primefaces.model.StreamedContent;

@Entity
@Table(name="TB_ANEXO")
@SequenceGenerator(name="ANE_ID", sequenceName="ANE_ID", allocationSize=1)
@NamedQueries({
    @NamedQuery(name="AnexoEntity.findById", 
    		query="SELECT obj "
    				+ " FROM AnexoEntity obj "
    				+ " WHERE obj.id = :id"),
    				
    @NamedQuery(name="AnexoEntity.findByEvidenciaID", 
			query="SELECT obj "
					+ " FROM AnexoEntity obj "
					+ "	INNER JOIN obj.evidencia evi "
					+ " WHERE evi.id = :evidenciaID")
})
public class AnexoEntity extends Anexo {

	private static final long serialVersionUID = 1L;
	
	public AnexoEntity(){
	}
	
	public AnexoEntity(String nome, byte[] arquivo, EvidenciaEntity evidencia) {
		setNome(nome);
		setArquivo(arquivo);
		setEvidencia(evidencia);
	}

	private StreamedContent fileAux;

	public StreamedContent getFileAux() {
		return fileAux;
	}

	public void setFileAux(StreamedContent fileAux) {
		this.fileAux = fileAux;
	}
	
}
