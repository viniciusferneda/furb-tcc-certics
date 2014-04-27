package vinicius.ferneda.tcc.certics.constant;

public enum EnumPapelUsuario {

	ADM("Administrador"),
	AVALIADOR("Avaliador"),
	AVALIADO("Avaliado");
	
	private String nome;
	
	/**
	 * Construtor do enum, com parametro nomeExtenso.
	 * 
	 * @param nome
	 *            String - O nome por extenso do enum
	 */
	private EnumPapelUsuario(String nome) {
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
