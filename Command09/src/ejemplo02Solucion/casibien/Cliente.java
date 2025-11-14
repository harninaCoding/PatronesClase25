package ejemplo02Solucion.casibien;
import org.junit.jupiter.api.Test;

public class Cliente {

	@Test
	void test() {
		Facade facade=new Facade();
		Libro libro=new Libro();
		FacadeCommandLibro facadeCommandLibro=new FacadeCommandLibro(new RepoLibro());
		Long id = 0L;
		//como evitar esto, parece command pero no lo es porque el cliente debe
		//conocer la orden que quiere
		facade.grabar(facadeCommandLibro,libro);
		facade.borrar(facadeCommandLibro, id);
	}
	
}
;