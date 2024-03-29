package Entidad;

public class Clientes {
	private int codigo_;
	private String codigo;
	private String nombre;
	private String apellido;
	private String dni;
	private int edad;
	private String fechaNac;
	private String genero;
	private String estadoCivil;
	private String celular;
	private String correo;
	private String direccion;
	
	public Clientes() {
		
	}

	public Clientes(int codigo_, String codigo, String nombre, String apellido, String dni, int edad, String fechaNac,
			String genero, String estadoCivil, String celular, String correo, String direccion) {
		this.codigo_ = codigo_;
		this.codigo = codigo;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.edad = edad;
		this.fechaNac = fechaNac;
		this.genero = genero;
		this.estadoCivil = estadoCivil;
		this.celular = celular;
		this.correo = correo;
		this.direccion = direccion;
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

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(String fechaNac) {
		this.fechaNac = fechaNac;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
}
