package vinicius.ferneda.tcc.certics.util;

import br.gov.frameworkdemoiselle.exception.ApplicationException;

@ApplicationException(rollback = true)
public class ExceptionUtils extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExceptionUtils(String mensagem) {
		super(mensagem);
	}

}
