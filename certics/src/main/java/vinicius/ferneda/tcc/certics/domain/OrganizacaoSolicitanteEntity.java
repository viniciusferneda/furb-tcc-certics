package vinicius.ferneda.tcc.certics.domain;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="TB_ORGANIZACAO_SOLICITANTE")
@NamedQueries({
    @NamedQuery(name="OrganizacaoSolicitanteEntity.findById", query="SELECT obj FROM OrganizacaoSolicitanteEntity obj WHERE obj.id = :id")
})
public class OrganizacaoSolicitanteEntity extends OrganizacaoSolicitante {

	private static final long serialVersionUID = 1L;
	
	public OrganizacaoSolicitanteEntity(){
	}
	
	public OrganizacaoSolicitanteEntity(String nome, String razaoSocial, String cnpj, String fone1, String fone2, EnderecoEntity endereco) {
		setNome(nome);
		setRazaoSocial(razaoSocial);
		setCnpj(cnpj);
		setFone1(fone1);
		setFone2(fone2);
		setEndereco(endereco);
	}
}
