package vinicius.ferneda.tcc.certics.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import vinicius.ferneda.tcc.certics.constant.EnumPontuacaoAvaliacao;

@Entity
@Table(name="TB_AVALIACAO")
@SequenceGenerator(name="AVA_ID", sequenceName="AVA_ID", allocationSize=1)
@NamedQueries({
    @NamedQuery(name="AvaliacaoEntity.findById", 
    		query="SELECT obj "
    				+ " FROM AvaliacaoEntity obj "
    				+ " WHERE obj.id = :id")
})
public class AvaliacaoEntity extends Avaliacao {

	private static final long serialVersionUID = 1L;

	public AvaliacaoEntity(){
	}
	
	public AvaliacaoEntity(EnumPontuacaoAvaliacao pontuacao, Date dataAvaliacao, SoftwareEntity software, AvaliadorEntity avaliador, VersaoCerticsEntity versaoCertics) {
		setPontuacao(pontuacao);
		setDataAvaliacao(dataAvaliacao);
		setSoftware(software);
		setAvaliador(avaliador);
		setVersaoCertics(versaoCertics);
	}

}
