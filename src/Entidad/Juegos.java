package Entidad;

public class Juegos {
	
	private int codigo_;
	private String codigo;
	private String nombre;
	private String desarrolladora;
	private String plataforma;
	private double precio;
	private int stock;
	private String categoria;
	
	public Juegos() {
		
	}
	
	public Juegos(int codigo_, String codigo, String nombre, String desarrolladora, String plataforma, double precio,
			int stock, String categoria) {
		this.codigo_ = codigo_;
		this.codigo = codigo;
		this.nombre = nombre;
		this.desarrolladora = desarrolladora;
		this.plataforma = plataforma;
		this.precio = precio;
		this.stock = stock;
		this.categoria = categoria;
	}

	public int getCodigo_() {
		return codigo_;
	}

	public void setCodigo_(int codigo_) {
		this.codigo_ = codigo_;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDesarrolladora() {
		return desarrolladora;
	}

	public void setDesarrolladora(String desarrolladora) {
		this.desarrolladora = desarrolladora;
	}

	public String getPlataforma() {
		return plataforma;
	}

	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
}
