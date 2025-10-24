package telescope01;

public class SocioTelescopio {
	// atributos obligatorios
	private String nombre;
	private int edad;
	private String ciudad;
	// atributos 
	private String plazaAparcamiento;
	private String numeroDespacho;
	
	public SocioTelescopio(String nombre, int edad, String ciudad) {
		super();
		this.nombre = nombre;
		this.edad = edad;
		this.ciudad = ciudad;
	}

	public SocioTelescopio(String nombre, int edad, String ciudad, String plazaAparcamiento) {
		this(nombre,edad,ciudad);
		this.plazaAparcamiento=plazaAparcamiento;
	}

	public SocioTelescopio(String nombre, int edad, String ciudad, String plazaAparcamiento, String numeroDespacho) {
		this(nombre,edad,ciudad,plazaAparcamiento);
		this.numeroDespacho = numeroDespacho;
	}
	//Firma del metodo
	public SocioTelescopio(String nombre, int edad, String ciudad,String numeroDespacho) {
		this(nombre,edad,ciudad,plazaAparcamiento);
		this.numeroDespacho = numeroDespacho;
	}
	public SocioTelescopio(String , int , String , String ) {
		this(nombre,edad,ciudad,plazaAparcamiento);
		this.numeroDespacho = numeroDespacho;
	}
	
	
}
