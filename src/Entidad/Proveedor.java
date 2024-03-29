package Entidad;

public class Proveedor {
	private int codigo_;
	private String codigo;
	private String razonSocial;
	private String ruc;
	private String contacto;
	private String correo;
	private String direccion;
	private String sede;
	
	public Proveedor() {
		
	}

	public Proveedor(int codigo_, String codigo, String razonSocial, String ruc, String contacto, String correo,
			String direccion, String sede) {
		this.codigo_ = codigo_;
		this.codigo = codigo;
		this.razonSocial = razonSocial;
		this.ruc = ruc;
		this.contacto = contacto;
		this.correo = correo;
		this.direccion = direccion;
		this.sede = sede;
	}

	public int getCodigo_() {
		return codigo_;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public String getRuc() {
		return ruc;
	}

	public String getContacto() {
		return contacto;
	}

	public String getCorreo() {
		return correo;
	}

	public String getDireccion() {
		return direccion;
	}

	public String getSede() {
		return sede;
	}

	public void setCodigo_(int codigo_) {
		this.codigo_ = codigo_;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public void setRuc(String ruc) {
		this.ruc = ruc;
	}

	public void setContacto(String contacto) {
		this.contacto = contacto;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public void setSede(String sede) {
		this.sede = sede;
	}
	

}
