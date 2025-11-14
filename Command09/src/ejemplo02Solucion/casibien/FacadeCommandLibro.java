package ejemplo02Solucion.casibien;
public class FacadeCommandLibro implements FacadeCommand<Libro,Long>{

	Repo repo;
	
	public FacadeCommandLibro(Repo repo){
		super();
		this.repo = repo;
	}
	
	@Override
	public void grabar(Libro libro) {
		repo.grabar(libro);
	}
	
	@Override
	public void borrar(Long id) {
		repo.borrar(id);
	}
}
