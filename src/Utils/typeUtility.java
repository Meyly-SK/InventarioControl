package Utils;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class typeUtility {

	// --- Clientes --- Empleados ---
	private int codigo;
	private int nombre;
	private int apellido;
	private int dni;
	private int edad;
	private int fechaNac;
	private int genero;
	private int estadoCivil;
	private int celular;
	private int correo;
	private int direccion;
	private int cargo;
	private int sede;
	private int usuario;
	private int clave;
	private int ir_a;
	private int modelo;
	private int color;
	private int precio;
	private int stock;
	private int desarrolladora;
	private int plataforma;
	private int tipoconex;
	private int marca;
	private int descripcion;
	private int procesador;
	private int placamadre;
	private int size;
	private int tarjetavideo;
	private int refrigeracion;
	private int fuentepoder;
	private int pantalla;
	private int discoduro;
	private int check;
	private int razonSocial;
	private int ruc;
	private int contacto;
	private int num;
	private int codBoleta;
	private int cod_Empleado;
	private int cod_Cli_Prov;
	private int fechaVenta;
	private int importe;
	
	
	//-------------------------------------


	// --- Clientes --- Empleados ---

	public typeUtility(String table) {
		switch (table) {
		case "Proveedor": {
			codigo = 0;
			razonSocial = 1;
			ruc = 2;
			contacto = 3;
			correo = 4;
			direccion = 5;
			sede = 6;
			break;
			
		}case "Boleta": {
			num = 0;
			codBoleta = 1;
			cod_Empleado = 2;
			cod_Cli_Prov = 3;
			fechaVenta = 4;
			descripcion = 5;
			importe = 6;
			break;
			
		}
		case "Empleados": {
			codigo = 0;
			nombre = 1;
			apellido = 2;
			dni = 3;
			edad = 4;
			fechaNac = 5;
			genero = 6;
			estadoCivil = 7;
			celular = 8;
			correo = 9;
			direccion = 10;
			cargo = 11;
			sede = 12;
			ir_a = 13;
			//usuario = 13;
			//clave = 14;
			break;
		}
		case "Clientes": {
			codigo = 0;
			nombre = 1;
			apellido = 2;
			dni = 3;
			edad = 4;
			fechaNac = 5;
			genero = 6;
			estadoCivil = 7;
			celular = 8;
			correo = 9;
			direccion = 10;
			ir_a = 11;
			break;
		}
		case "Consolas": {
			codigo = 0;
			nombre = 1;
			modelo = 2;
			color = 3;
			precio = 4;
			stock = 5;
			check = 6;
			break;
		}
		case "Juegos": {
			codigo = 0;
			nombre = 1;
			desarrolladora = 2;
			plataforma = 3;
			precio = 4;
			stock = 5;
			check = 6;
			break;
		}
		case "Mandos": {
			codigo = 0;
			nombre = 1;
			marca = 2;
			tipoconex = 3;
			precio = 4;
			stock = 5;
			check = 6;
			break;
		}
		case "AudifonosGamer": {
			codigo = 0;
			marca = 1;
			modelo = 2;
			descripcion = 3;
			tipoconex = 4;
			precio = 5;
			stock = 6;
			check = 7;
			break;
		}
		case "SillasGamer": {
			codigo = 0;
			marca = 1;
			modelo = 2;
			descripcion = 3;
			precio = 4;
			stock = 5;
			check = 6;
			break;
		}
		case "PCGamer": {
			codigo = 0;
			procesador = 1;
			discoduro = 2;
			placamadre = 3;
			tarjetavideo = 4;
			fuentepoder = 5;
			refrigeracion = 6;
			precio = 7;
			stock = 8;
			check = 9;
			break;
		}
		case "LaptopGamer": {
			codigo = 0;
			marca = 1;
			modelo = 2;
			procesador = 3;
			tarjetavideo = 4;
			size = 5;
			precio = 6;
			stock = 7;
			check = 8;
			break;
		}
		case "MouseGamer": {
			codigo = 0;
			marca = 1;
			modelo = 2;
			descripcion = 3;
			tipoconex = 4;
			precio = 5;
			stock = 6;
			check = 7;
			break;
		}
		case "TecladosGamer": {
			codigo = 0;
			marca = 1;
			modelo = 2;
			descripcion = 3;
			tipoconex = 4;
			precio = 5;
			stock = 6;
			check = 7;
			break;
		}
		case "Celulares": {
			codigo = 0;
			marca = 1;
			modelo = 2;
			descripcion = 3;
			precio = 4;
			stock = 5;
			check = 6;
			break;
		}
		case "Televisores": {
			codigo = 0;
			marca = 1;
			modelo = 2;
			descripcion = 3;
			precio = 4;
			stock = 5;
			check = 6;
			break;
		}
		case "Parlantes": {
			codigo = 0;
			marca = 1;
			modelo = 2;
			descripcion = 3;
			tipoconex = 4;
			precio = 5;
			stock = 6;
			check = 7;
			break;
		}
		case "Audifonos": {
			codigo = 0;
			marca = 1;
			modelo = 2;
			descripcion = 3;
			tipoconex = 4;
			precio = 5;
			stock = 6;
			check = 7;
			break;
		}
		case "PC": {
			codigo = 0;
			procesador = 1;
			discoduro = 2;
			placamadre = 3;
			tarjetavideo = 4;
			fuentepoder = 5;
			refrigeracion = 6;
			precio = 7;
			stock = 8;
			check = 9;
			break;
		}
		case "Laptop": {
			codigo = 0;
			marca = 1;
			modelo = 2;
			procesador = 3;
			tarjetavideo = 4;
			pantalla = 5;
			precio = 6;
			stock = 7;
			check = 8;
			break;
		}
		case "Tablet": {
			codigo = 0;
			marca = 1;
			modelo = 2;
			procesador = 3;
			descripcion = 4;
			precio = 5;
			stock = 6;
			check = 7;
			break;
		}
		case "Mouse": {
			codigo = 0;
			marca = 1;
			modelo = 2;
			descripcion =3;
			tipoconex = 4;
			precio = 5;
			stock = 6;
			check = 7;
			break;
		}
		case "Microfonos": {
			codigo = 0;
			marca = 1;
			modelo = 2;
			tipoconex = 3;
			precio = 4;
			stock = 5;
			check = 6;
			break;
		}
		case "CamaraWeb": {
			codigo = 0;
			marca = 1;
			modelo = 2;
			tipoconex = 3;
			precio = 4;
			stock = 5;
			check = 6;
			break;
		}
		case "Teclados": {
			codigo = 0;
			marca = 1;
			modelo = 2;
			descripcion = 3;
			tipoconex = 4;
			precio = 5;
			stock = 6;
			check = 7;
			break;
		}

		default:
			throw new IllegalArgumentException("No se encuentra el TypeUtility: " + table);
		}
	}


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public int getNombre() {
		return nombre;
	}


	public void setNombre(int nombre) {
		this.nombre = nombre;
	}


	public int getApellido() {
		return apellido;
	}


	public void setApellido(int apellido) {
		this.apellido = apellido;
	}


	public int getDni() {
		return dni;
	}


	public void setDni(int dni) {
		this.dni = dni;
	}


	public int getEdad() {
		return edad;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public int getFechaNac() {
		return fechaNac;
	}


	public void setFechaNac(int fechaNac) {
		this.fechaNac = fechaNac;
	}


	public int getGenero() {
		return genero;
	}


	public void setGenero(int genero) {
		this.genero = genero;
	}


	public int getEstadoCivil() {
		return estadoCivil;
	}


	public void setEstadoCivil(int estadoCivil) {
		this.estadoCivil = estadoCivil;
	}


	public int getCelular() {
		return celular;
	}


	public void setCelular(int celular) {
		this.celular = celular;
	}


	public int getCorreo() {
		return correo;
	}


	public void setCorreo(int correo) {
		this.correo = correo;
	}


	public int getDireccion() {
		return direccion;
	}


	public void setDireccion(int direccion) {
		this.direccion = direccion;
	}


	public int getCargo() {
		return cargo;
	}


	public void setCargo(int cargo) {
		this.cargo = cargo;
	}


	public int getSede() {
		return sede;
	}


	public void setSede(int sede) {
		this.sede = sede;
	}


	public int getUsuario() {
		return usuario;
	}


	public void setUsuario(int usuario) {
		this.usuario = usuario;
	}


	public int getClave() {
		return clave;
	}


	public void setClave(int clave) {
		this.clave = clave;
	}


	public int getIr_a() {
		return ir_a;
	}


	public void setIr_a(int ir_a) {
		this.ir_a = ir_a;
	}


	public int getModelo() {
		return modelo;
	}


	public void setModelo(int modelo) {
		this.modelo = modelo;
	}


	public int getColor() {
		return color;
	}


	public void setColor(int color) {
		this.color = color;
	}


	public int getPrecio() {
		return precio;
	}


	public void setPrecio(int precio) {
		this.precio = precio;
	}


	public int getStock() {
		return stock;
	}


	public void setStock(int stock) {
		this.stock = stock;
	}


	public int getDesarrolladora() {
		return desarrolladora;
	}


	public void setDesarrolladora(int desarrolladora) {
		this.desarrolladora = desarrolladora;
	}


	public int getPlataforma() {
		return plataforma;
	}


	public void setPlataforma(int plataforma) {
		this.plataforma = plataforma;
	}


	public int getTipoconex() {
		return tipoconex;
	}


	public int getMarca() {
		return marca;
	}


	public void setTipoconex(int tipoconex) {
		this.tipoconex = tipoconex;
	}


	public void setMarca(int marca) {
		this.marca = marca;
	}


	public int getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(int descripcion) {
		this.descripcion = descripcion;
	}


	public int getProcesador() {
		return procesador;
	}


	public int getPlacamadre() {
		return placamadre;
	}


	public int getSize() {
		return size;
	}


	public int getTarjetavideo() {
		return tarjetavideo;
	}


	public int getRefrigeracion() {
		return refrigeracion;
	}


	public int getFuentepoder() {
		return fuentepoder;
	}


	public int getPantalla() {
		return pantalla;
	}


	public int getDiscoduro() {
		return discoduro;
	}


	public void setProcesador(int procesador) {
		this.procesador = procesador;
	}


	public void setPlacamadre(int placamadre) {
		this.placamadre = placamadre;
	}


	public void setSize(int size) {
		this.size = size;
	}


	public void setTarjetavideo(int tarjetavideo) {
		this.tarjetavideo = tarjetavideo;
	}


	public void setRefrigeracion(int refrigeracion) {
		this.refrigeracion = refrigeracion;
	}


	public void setFuentepoder(int fuentepoder) {
		this.fuentepoder = fuentepoder;
	}


	public void setPantalla(int pantalla) {
		this.pantalla = pantalla;
	}


	public void setDiscoduro(int discoduro) {
		this.discoduro = discoduro;
	}


	public int getCheck() {
		return check;
	}


	public void setCheck(int check) {
		this.check = check;
	}


	public int getRazonSocial() {
		return razonSocial;
	}


	public int getRuc() {
		return ruc;
	}


	public int getContacto() {
		return contacto;
	}


	public void setRazonSocial(int razonSocial) {
		this.razonSocial = razonSocial;
	}


	public void setRuc(int ruc) {
		this.ruc = ruc;
	}


	public void setContacto(int contacto) {
		this.contacto = contacto;
	}


	public int getNum() {
		return num;
	}


	public int getCodBoleta() {
		return codBoleta;
	}


	public int getCod_Empleado() {
		return cod_Empleado;
	}


	public int getFechaVenta() {
		return fechaVenta;
	}


	public int getImporte() {
		return importe;
	}


	public void setNum(int num) {
		this.num = num;
	}


	public void setCodBoleta(int codBoleta) {
		this.codBoleta = codBoleta;
	}


	public void setCod_Empleado(int cod_Empleado) {
		this.cod_Empleado = cod_Empleado;
	}


	public void setFechaVenta(int fechaVenta) {
		this.fechaVenta = fechaVenta;
	}


	public void setImporte(int importe) {
		this.importe = importe;
	}


	public int getCod_Cli_Prov() {
		return cod_Cli_Prov;
	}


	public void setCod_Cli_Prov(int cod_Cli_Prov) {
		this.cod_Cli_Prov = cod_Cli_Prov;
	}

}
