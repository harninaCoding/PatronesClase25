package ejemplo02Solucion.bientotalmente;

import java.util.Optional;

import org.junit.jupiter.api.Test;

public class Cliente {

	@Test
	void test() {
		Facade facade = new Facade();
		Libro libro = new Libro();
		RepoLibro repoLibro = new RepoLibro();
		GrabarLibroCommand grabarCommandLibro = new GrabarLibroCommand(repoLibro, libro);
		facade.setCommand(grabarCommandLibro);
		facade.executeCommand();
		BorrarLibroCommand borrarLibroCommand=new BorrarLibroCommand(repoLibro, 1L);
		facade.setCommand(borrarLibroCommand);
		facade.executeCommand();
		BuscarLibroCommand buscarLibroCommand=new BuscarLibroCommand(repoLibro, 1L);
		facade.setCommand(buscarLibroCommand);
		facade.executeCommand();
		//pero esto es un poco sucio y empeora la sensacion de que el command sea adeucado
		Optional<Libro> libro2 = buscarLibroCommand.getLibro();
	}

};