package vinicius.ferneda.tcc.certics.constant;

public enum EnumUF {

	AC("Acre"), 
	AL("Alagoas"), 
	AM("Amazonas"), 
	AP("Amapa"), 
	BA("Bahia"), 
	CE("Ceara"), 
	DF("Distrito Federal"), 
	ES("Espirito Santo"), 
	GO("Goias"), 
	MA("Maranhao"), 
	MG("Minas Gerais"), 
	MT("Mato Grosso"), 
	MS("Mato Grosso do Sul"), 
	PA("Para"), 
	PB("Paraiba"), 
	PE("Pernambuco"), 
	PI("Piaui"), 
	PR("Parana"), 
	RJ("Rio de Janeiro"), 
	RN("Rio Grande do Norte"), 
	RO("Rondonia"), 
	RR("Roraima"), 
	RS("Rio Grande do Sul"), 
	SC("Santa Catarina"), 
	SE("Sergipe"), 
	SP("Sao Paulo"), 
	TO("Tocantins");

	private String nome;

	/**
	 * Construtor do enum, com parametro nomeExtenso.
	 * 
	 * @param nome
	 *            String - O nome por extenso do enum
	 */
	private EnumUF(String nome) {
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
