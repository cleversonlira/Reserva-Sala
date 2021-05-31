package br.com.salareunioes.model;

public class Recurso {

	private Integer idSala;
	private String tipo;
	
	public Integer getId() {
		return idSala;
	}
	
	public void setId(Integer id) {
		this.idSala = id;
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return "Recurso [id=" + idSala + ", tipo=" + tipo + "]";
	}	
		
}
