package vinicius.ferneda.tcc.certics.persistence;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

import vinicius.ferneda.tcc.certics.domain.Endereco;

@PersistenceController
public class EnderecoDAO extends JPACrud<Endereco, Long> {

	private static final long serialVersionUID = 1L;
	

}
