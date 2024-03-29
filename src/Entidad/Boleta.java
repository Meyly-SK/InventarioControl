package Entidad;

public class Boleta {
	
	private int num;
	private String codBoleta;
	private String cod_Empleado;
	private String cod_Cli_Prov;
	private String fechaVenta;
	private String descripcion;
	private double importe;
	
	
	public Boleta() {
		
	}
	
	
	public Boleta(int num, String codBoleta, String cod_Empleado, String cod_Cli_Prov, String fechaVenta, String descripcion,
			double importe) {
		this.num = num;
		this.codBoleta = codBoleta;
		this.cod_Empleado = cod_Empleado;
		this.cod_Cli_Prov = cod_Cli_Prov;
		this.fechaVenta = fechaVenta;
		this.descripcion = descripcion;
		this.importe = importe;
	}


	public int getNum() {
		return num;
	}
	public String getCodBoleta() {
		return codBoleta;
	}
	public String getCod_Empleado() {
		return cod_Empleado;
	}
	public String getCod_Cli_Prov() {
		return cod_Cli_Prov;
	}
	public String getFechaVenta() {
		return fechaVenta;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public double getImporte() {
		return importe;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public void setCodBoleta(String codBoleta) {
		this.codBoleta = codBoleta;
	}
	public void setCod_Empleado(String cod_Empleado) {
		this.cod_Empleado = cod_Empleado;
	}
	public void setCod_Cli_Prov(String cod_Cli_Prov) {
		this.cod_Cli_Prov = cod_Cli_Prov;
	}
	public void setFechaVenta(String fechaVenta) {
		this.fechaVenta = fechaVenta;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public void setImporte(double importe) {
		this.importe = importe;
	}

}
