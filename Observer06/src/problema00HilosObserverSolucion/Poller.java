package problema00HilosObserverSolucion;

import java.util.Observable;
import java.util.Observer;

public class Poller implements Runnable, Observer {
	private int shabbyNumber = 0;
	private long counter = 0;
	private int changes = 0;

	public Poller() {
		super();
	}

	@Override
	public void run() {
		do {
			// si es un hilo es que tiene cosas que hacer
			try {
				wait();
				System.out.println("Hago mis cosas " + shabbyNumber);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			// fuera del hilo, podemos usar Observer
		} while (true);
	}

	@Override
	public void update(Observable o, Object arg) {
		System.err.println("cambio valor");
		shabbyNumber = (int) arg;
		notify();
	}

}
