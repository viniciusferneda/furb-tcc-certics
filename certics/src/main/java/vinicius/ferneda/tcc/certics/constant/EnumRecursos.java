package vinicius.ferneda.tcc.certics.constant;

public enum EnumRecursos {

	ANEXO("anexo"),
	AREA_COMPETENCIA("area_competencia"),
	AVALIACAO("avaliacao"),
	AVALIADOR("avaliador"),
	CONJUNTO_EVIDENCIAS("conjunto_evidencias"),
	ENDERECO("endereco"),
	EVIDENCIA("evidencia"),
	EVIDENCIA_PROFISSIONAL("evidencia_profissional"),
	LICAO_APRENDIDA("licao_aprendida"),
	ORGANIZACAO_SOLICITANTE("organizacao_solicitante"),
	PESSOA_FISICA("pessoa_fisica"),
	PROFISSIONAL("profissional"),
	RESPOSTA_EVIDENCIA("reposta_evidencia"),
	RESULTADO_ESPERADO("resultado_esperado"),
	SOFTWARE("software"),
	USUARIO("usuario");
	
	private String nome;
	
	/**
	 * Construtor do enum, com parametro nomeExtenso.
	 * 
	 * @param nome
	 *            String - O nome por extenso do enum
	 */
	private EnumRecursos(String nome) {
		this.nome = nome;
	}

	/**
	 * Retorna o nome em extenso do enum.
	 * 
	 * @return String - O nome por extenso
	 */
	public String getNome() {
		return nome;
	}
	
}
