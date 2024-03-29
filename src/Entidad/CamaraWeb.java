package Entidad;

public class CamaraWeb {
	private int codigo_;
	private String codigo;
	private String marca;
	private String modelo;
	private String tipoconex;
	private double precio;
	private int stock;
	private String categoria;
	
	public CamaraWeb() {
		
	}
	
	public CamaraWeb(int codigo_, String codigo, String marca, String modelo, String tipoconex, double precio,
			int stock, String categoria) {
		this.codigo_ = codigo_;
		this.codigo = codigo;
		this.marca = marca;
		this.modelo = modelo;
		this.tipoconex = tipoconex;
		this.precio = precio;
		this.stock = stock;
		this.categoria = categoria;
	}



	public int getCodigo_() {
		return codigo_;
	}



	public String getCodigo() {
		return codigo;
	}



	public String getMarca() {
		return marca;
	}



	public String getModelo() {
		return modelo;
	}



	public String getTipoconex() {
		return tipoconex;
	}



	public double getPrecio() {
		return precio;
	}



	public int getStock() {
		return stock;
	}



	public String getCategoria() {
		return categoria;
	}



	public void setCodigo_(int codigo_) {
		this.codigo_ = codigo_;
	}



	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}



	public void setMarca(String marca) {
		this.marca = marca;
	}



	public void setModelo(String modelo) {
		this.modelo = modelo;
	}



	public void setTipoconex(String tipoconex) {
		this.tipoconex = tipoconex;
	}



	public void setPrecio(double precio) {
		this.precio = precio;
	}



	public void setStock(int stock) {
		this.stock = stock;
	}



	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

}
