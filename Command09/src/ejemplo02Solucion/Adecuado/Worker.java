package ejemplo02Solucion.Adecuado;

import java.util.concurrent.BlockingQueue;

public class Worker implements Runnable {
    private final BlockingQueue<Command> cola;

    public Worker(BlockingQueue<Command> cola) {
        this.cola = cola;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Command c = cola.take();
                c.execute();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
