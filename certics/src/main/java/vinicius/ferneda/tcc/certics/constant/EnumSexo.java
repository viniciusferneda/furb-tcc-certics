package vinicius.ferneda.tcc.certics.constant;

public enum EnumSexo {

	MASCULINO("Masculino"),
	FEMININO("Feminino");
	
	private String nome;
	
	/**
	 * Construtor do enum, com parametro nomeExtenso.
	 * 
	 * @param nome
	 *            String - O nome por extenso do enum
	 */
	private EnumSexo(String nome) {
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
