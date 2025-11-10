package ejemplo02problema;

public class ClienteConFacade {
	public static void main(String[] args) {
		Libro libro=new Libro();
		Facade facade=new Facade();
		facade.grabar(libro);
		Socio socio=new Socio();
		facade.grabar(socio);
		///
		facade.borrarLibro(libro.id);
		facade.borrarSocio(socio.id);
	}
}
