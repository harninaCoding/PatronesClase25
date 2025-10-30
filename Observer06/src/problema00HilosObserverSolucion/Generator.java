package problema00HilosObserverSolucion;

import java.util.Observable;
import java.util.Random;

public class Generator extends Observable implements Runnable {

	private int awesomeValue = 0;

	@Override
	public void run() {
		do {
			try {
				int nextInt = new Random().nextInt(4000);
				Thread.sleep(nextInt);
				awesomeValue = nextInt;
				setChanged();
				notifyObservers(awesomeValue);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} while (true);
	}

	public int getAwesomeValue() {
		return awesomeValue;
	}

}
