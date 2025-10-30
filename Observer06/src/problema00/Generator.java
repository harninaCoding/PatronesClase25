package problema00;
import java.util.Random;

public class Generator implements Runnable{

	private int awesomeValue=0;
	
	@Override
	public void run() {
		do {
			try {
				int nextInt = new Random().nextInt(10);
				System.out.println("generando numero pausa "+nextInt);
				Thread.sleep(nextInt);
				awesomeValue=nextInt;
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}while(true);
	}

	public int getAwesomeValue() {
		return awesomeValue;
	}

	
}
