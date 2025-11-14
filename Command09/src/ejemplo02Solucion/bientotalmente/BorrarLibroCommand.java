package ejemplo02Solucion.bientotalmente;

public class BorrarLibroCommand implements Command {
	
	private final RepoLibro repoLibro;
	private final Long id;	

	public BorrarLibroCommand(RepoLibro repoLibro, Long id) {
		super();
		this.repoLibro = repoLibro;
		this.id = id;
	}

	@Override
	public void execute() {
		repoLibro.borrar(id);	
	}

}
