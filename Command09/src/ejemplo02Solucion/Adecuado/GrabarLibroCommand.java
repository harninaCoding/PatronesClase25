package ejemplo02Solucion.Adecuado;

public class GrabarLibroCommand implements Command {
    private final RepoLibro repo;
    private final Libro libro;

    public GrabarLibroCommand(RepoLibro repo, Libro libro) {
        this.repo = repo;
        this.libro = libro;
    }

    @Override
    public void execute() {
        repo.grabar(libro);
    }
}
