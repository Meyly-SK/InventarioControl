package Entidad;

public class Categoria {
	
	private String codigo;
	private String categoria;
	
	public Categoria() {
		
	}
	public Categoria(String codigo, String categoria) {
		this.codigo = codigo;
		this.categoria = categoria;
	}
	public String getCodigo() {
		return codigo;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

}
