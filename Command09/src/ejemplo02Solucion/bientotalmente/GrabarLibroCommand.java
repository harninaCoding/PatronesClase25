package ejemplo02Solucion.bientotalmente;

public class GrabarLibroCommand implements Command {
	
	private final RepoLibro repoLibro;
	private final Libro libro;	

	public GrabarLibroCommand(RepoLibro repoLibro,Libro libro) {
		super();
		this.repoLibro = repoLibro;
		this.libro=libro;
	}

	@Override
	public void execute() {
		repoLibro.grabar(libro);	
	}

}
