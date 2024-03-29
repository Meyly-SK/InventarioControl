package Entidad;

public class PCGamer {
	
	private int codigo_;
	private String codigo;
	private String procesador;
	private String discoduro;
	private String placamadre;
	private String tarjVideo;
	private String fuentePoder;
	private String refrigeracion;
	private double precio;
	private int stock;
	private String categoria;
	
	public PCGamer() {
		
	}
	
	public PCGamer(int codigo_, String codigo, String procesador, String discoduro, String placamadre, String tarjVideo,
			String fuentePoder, String refrigeracion, double precio, int stock, String categoria) {
		this.codigo_ = codigo_;
		this.codigo = codigo;
		this.procesador = procesador;
		this.discoduro = discoduro;
		this.placamadre = placamadre;
		this.tarjVideo = tarjVideo;
		this.fuentePoder = fuentePoder;
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

	public String getTarjVideo() {
		return tarjVideo;
	}

	public String getFuentePoder() {
		return fuentePoder;
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

	public void setTarjVideo(String tarjVideo) {
		this.tarjVideo = tarjVideo;
	}

	public void setFuentePoder(String fuentePoder) {
		this.fuentePoder = fuentePoder;
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
