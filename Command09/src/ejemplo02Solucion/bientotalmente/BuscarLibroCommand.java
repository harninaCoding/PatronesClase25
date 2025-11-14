package ejemplo02Solucion.bientotalmente;

import java.util.Optional;

public class BuscarLibroCommand implements Command{
	private final RepoLibro repoLibro;
	//Long o lo que sea el tipo de indice
	private final Long id;
	private Optional<Libro> libro;
	
	//aunque este ejemplo lo hace demasiado complicado es mas util
	//en ejemploAdecuado
	
	protected BuscarLibroCommand(RepoLibro repoLibro, Long id) {
		super();
		this.repoLibro = repoLibro;
		this.id = id;
	}

	@Override
	public void execute() {
		libro=repoLibro.buscar(id);
	}

	public Optional<Libro> getLibro() {
		return libro;
	}
	
}
