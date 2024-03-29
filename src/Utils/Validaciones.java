package Utils;

public class Validaciones {
	public static final String TEXTO="\\D{1,40}";
	public static final String NOM_APE="[a-zA-z¡…Õ”⁄·ÈÌÛ˙\\s]{3,30}";
	public static final String DNI="[0-9]{8}";
	public static final String DNI_CONSULTA="[0-9]{1,8}";
	public static final String CELULAR="[0-9]{9}";
	public static final String CELULAR_CONSULTA="[0-9]{9}";
	public static final String CORREO="^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	public static final String DIRECCION="[\\w.\\s]{10,80}";
	public static final String DIRECCION_CONSULTA="[\\w.\\s]{10,80}";
}
