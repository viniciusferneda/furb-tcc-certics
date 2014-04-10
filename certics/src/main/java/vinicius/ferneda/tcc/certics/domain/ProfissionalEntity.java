package vinicius.ferneda.tcc.certics.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import vinicius.ferneda.tcc.certics.constant.EnumSexo;

@Entity
@Table(name="TB_PESSOA_FISICA")
@NamedQueries({
    @NamedQuery(name="ProfissionalEntity.findById", query="SELECT obj FROM ProfissionalEntity obj WHERE obj.id = :id")
})
public class ProfissionalEntity extends Profissional {

	private static final long serialVersionUID = 1L;
	
	public ProfissionalEntity(){
	}
	
	public ProfissionalEntity(String vinculoAtual, Integer responsavelOrganizacao, OrganizacaoSolicitanteEntity organizacaoSolicitante,
			String nome, String cpf, String rg, EnumSexo sexo, Date dataNascimento, String fone1, String fone2, Endereco endereco) {
		super(vinculoAtual, responsavelOrganizacao, organizacaoSolicitante, nome, cpf, rg, sexo, dataNascimento, fone1, fone2, endereco);
	}
}
