package vinicius.ferneda.tcc.certics.view;

public class InformacoesArvore {

	private Long id;
	private String titulo;
	private String tipo;
	
	public InformacoesArvore(Long id, String titulo, String tipo){
		this.id = id;
		this.titulo = titulo;
		this.tipo = tipo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
}
