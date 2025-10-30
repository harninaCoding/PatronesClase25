package intentodeprecated01;

import java.util.Observable;
import java.util.Observer;

//Observer necesita saber cuando hay cmambios
public class Consumer implements Observer{
	public String mio="antiguo";

	@Override
	public void update(Observable o, Object arg) {
		mio=(String) arg;
		System.out.println("nuevo valor "+mio);
	}


}
