package intentodeprecated01;

import java.util.Observable;
import java.util.Observer;

public class Proveedor extends Observable{
	Object arg="dolor";
	
	public Proveedor(Observer observer) {
		super();
		addObserver(observer);
	}

	public Object getArg() {
		return arg;
	}

	public void setArg(Object arg) {
		this.arg = arg;
		setChanged();
		notifyObservers(arg);
	}

}
