package teorialambdasinparam05;
public abstract class Product {
	//se puede poner pero no se pueden hacer getters and setters
	int pcss=9;
	public int getPcss() {
		return pcss;
	}
	public void setPcss(int pcss) {
		this.pcss = pcss;
	}
	// Para propiedades y metodos comunes a las clases hijo
	public abstract void operacion();
	public Class quienSoy(){
		return this.getClass();
	}
	
}
