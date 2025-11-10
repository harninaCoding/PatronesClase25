package ejemplo02problema;

public class ClienteSinFacade {
public static void main(String[] args) {
	Libro libro=new Libro();
	RepoLibro repoLibro=new RepoLibro();
	repoLibro.grabar(libro);
}
}
