package vinicius.ferneda.tcc.certics.constant;

public enum EnumPontuacaoEvidencia {

	F("Completamente atendido"),
	L("Largamente atendido"),
	P("Parcialmente atendido"),
	N("Não atendido");
	
	private String nome;
	
	/**
	 * Construtor do enum, com parametro nomeExtenso.
	 * 
	 * @param nome
	 *            String - O nome por extenso do enum
	 */
	private EnumPontuacaoEvidencia(String nome) {
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
