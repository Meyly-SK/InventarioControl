package Entidad;

public class PCEscritorio {
	private int codigo_;
	private String codigo;
	private String procesador;
	private String discoduro;
	private String placamadre;
	private String tarjetavideo;
	private String fuentepoder;
	private String refrigeracion;
	private double precio;
	private int stock;
	private String categoria;
	
	public PCEscritorio() {
		
	}
	
	public PCEscritorio(int codigo_, String codigo, String procesador, String discoduro, String placamadre,
			String tarjetavideo, String fuentepoder, String refrigeracion, double precio, int stock, String categoria) {
		this.codigo_ = codigo_;
		this.codigo = codigo;
		this.procesador = procesador;
		this.discoduro = discoduro;
		this.placamadre = placamadre;
		this.tarjetavideo = tarjetavideo;
		this.fuentepoder = fuentepoder;
		this.refrigeracion = refrigeracion;
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

	public String getProcesador() {
		return procesador;
	}

	public String getDiscoduro() {
		return discoduro;
	}

	public String getPlacamadre() {
		return placamadre;
	}

	public String getTarjetavideo() {
		return tarjetavideo;
	}

	public String getFuentepoder() {
		return fuentepoder;
	}

	public String getRefrigeracion() {
		return refrigeracion;
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

	public void setProcesador(String procesador) {
		this.procesador = procesador;
	}

	public void setDiscoduro(String discoduro) {
		this.discoduro = discoduro;
	}

	public void setPlacamadre(String placamadre) {
		this.placamadre = placamadre;
	}

	public void setTarjetavideo(String tarjetavideo) {
		this.tarjetavideo = tarjetavideo;
	}

	public void setFuentepoder(String fuentepoder) {
		this.fuentepoder = fuentepoder;
	}

	public void setRefrigeracion(String refrigeracion) {
		this.refrigeracion = refrigeracion;
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
