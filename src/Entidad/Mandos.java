package Entidad;

public class Mandos {
	private int codigo_;
	private String codigo;
	private String nombre;
	private String marca;
	private double precio;
	private String tipoconex;
	private int stock;
	private String categoria;
	
	public Mandos() {
		
	}
	
	public Mandos(int codigo_, String codigo, String nombre, String marca, double precio, String tipoconex, int stock,
			String categoria) {
		this.codigo_ = codigo_;
		this.codigo = codigo;
		this.nombre = nombre;
		this.marca = marca;
		this.precio = precio;
		this.tipoconex = tipoconex;
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

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getTipoconex() {
		return tipoconex;
	}

	public void setTipoconex(String tipoconex) {
		this.tipoconex = tipoconex;
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
