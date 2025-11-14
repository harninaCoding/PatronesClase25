package ejemplo02Solucion.Adecuado;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Cliente {
    public static void main(String[] args) {
        BlockingQueue<Command> cola = new LinkedBlockingQueue<>();
        RepoLibro repo = new RepoLibro();

        Thread worker = new Thread(new Worker(cola));

        cola.add(new GrabarLibroCommand(repo, new Libro(1L, "A")));
        cola.add(new GrabarLibroCommand(repo, new Libro(2L, "B")));
        cola.add(new BorrarLibroCommand(repo, 1L));
        worker.start();
    }
}
