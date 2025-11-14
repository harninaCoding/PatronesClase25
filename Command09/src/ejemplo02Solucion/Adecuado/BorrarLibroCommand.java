package ejemplo02Solucion.Adecuado;

public class BorrarLibroCommand implements Command {
    private final RepoLibro repo;
    private final Long id;

    public BorrarLibroCommand(RepoLibro repo, Long id) {
        this.repo = repo;
        this.id = id;
    }

    @Override
    public void execute() {
        repo.borrar(id);
    }
}
