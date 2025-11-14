package ejemplo02Solucion.Adecuado;

public class RepoLibro {
    public void grabar(Libro libro) {
        System.out.println("Grabando " + libro);
    }

    public void borrar(Long id) {
        System.out.println("Borrando " + id);
    }
}
