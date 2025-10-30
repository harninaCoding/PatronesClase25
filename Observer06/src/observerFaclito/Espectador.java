package observerFaclito;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Espectador implements PropertyChangeListener{

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		System.out.println("Dios mio algo ha cambiado "+evt.getNewValue());
		System.out.println(evt.getOldValue());
		System.out.println(evt.getPropertyName());
		
	}

}
