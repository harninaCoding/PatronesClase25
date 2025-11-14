package ejemplo02Solucion.casibien;
public class Facade {

	public Facade() {
		super();
	}

	public void grabar(FacadeCommand repo,Object object) {
		repo.grabar(object);
	}
	
	public void borrar(FacadeCommand repo,Object object) {
		repo.borrar(object);
	}

}