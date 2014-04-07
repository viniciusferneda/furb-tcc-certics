package vinicius.ferneda.tcc.certics.constant;

public enum EnumVersaoCertics {

	V_1_0("v1.0");
	
	private String nome;
	
	/**
	 * Construtor do enum, com parametro nomeExtenso.
	 * 
	 * @param nome
	 *            String - O nome por extenso do enum
	 */
	private EnumVersaoCertics(String nome) {
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
