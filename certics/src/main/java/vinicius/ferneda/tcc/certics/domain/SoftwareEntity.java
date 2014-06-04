package vinicius.ferneda.tcc.certics.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="TB_SOFTWARE")
@SequenceGenerator(name="SOF_ID", sequenceName="SEQ_SOF_ID", allocationSize=1)
@NamedQueries({
    @NamedQuery(name="SoftwareEntity.findById", query="SELECT obj FROM SoftwareEntity obj WHERE obj.id = :id")
})
public class SoftwareEntity extends Software {

	private static final long serialVersionUID = 1L;
	
	public SoftwareEntity(){
	}
	
	public SoftwareEntity(String nome, String descricao, String historico, String tecnologias, String aspectoInovador, String release, Date dataInicio, Date dataLiberacaoVersao, OrganizacaoSolicitanteEntity organizacaoSolicitanteEntity) {
		setNome(nome);
		setDescricao(descricao);
		setHistorico(historico);
		setTecnologias(tecnologias);
		setAspectoInovador(aspectoInovador);
		setRelease(release);
		setDataInicio(dataInicio);
		setDataLiberacaoVersao(dataLiberacaoVersao);
		setOrganizacaoSolicitante(organizacaoSolicitanteEntity);
	}
	
}
