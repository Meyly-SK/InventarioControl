package Entidad;

public class Consolas {
	private int codigo_;
	private String codigo;
	private String nombre;
	private String modelo;
	private String color;
	private double precio;
	private int stock;
	private String categoria;

	public Consolas() {

	}

	public Consolas(int codigo_, String codigo, String nombre, String modelo, String color, double precio, int stock,
			String categoria) {
		this.codigo_ = codigo_;
		this.codigo = codigo;
		this.nombre = nombre;
		this.modelo = modelo;
		this.color = color;
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

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
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
