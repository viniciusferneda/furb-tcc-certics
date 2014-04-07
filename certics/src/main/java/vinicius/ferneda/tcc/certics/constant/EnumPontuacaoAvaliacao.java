package vinicius.ferneda.tcc.certics.constant;

public enum EnumPontuacaoAvaliacao {

	APROVADA("Aprovada"),
	PENDENTE("Pendente"),
	REPROVADA("Reprovada");
	
	private String nome;
	
	/**
	 * Construtor do enum, com parametro nomeExtenso.
	 * 
	 * @param nome
	 *            String - O nome por extenso do enum
	 */
	private EnumPontuacaoAvaliacao(String nome) {
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
