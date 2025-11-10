package ejemplo02problema;

public class Facade {
	RepoLibro repoLibro;
	RepoPrestamo repoPrestamo;
	RepoSocio repoSocio;

	public Facade() {
		super();
		repoLibro = new RepoLibro();
		repoSocio = new RepoSocio();
		repoPrestamo = new RepoPrestamo();
	}

	public void grabar(Libro libro) {
		repoLibro.grabar(libro);
	}

	public void grabar(Prestamo prestamo) {
		repoPrestamo.grabar(prestamo);
	}

	public void grabar(Socio socio) {
		repoSocio.grabar(socio);
	}
	
	public void borrarLibro(Long idLibro) {
		repoLibro.borrar(idLibro);
	}
	public void borrarSocio(Long idSocio) {
		repoSocio.borrar(idSocio);
	}
	public void borrarPrestamo(Long idPrestamo) {
		repoPrestamo.borrar(idPrestamo);
	}

}
