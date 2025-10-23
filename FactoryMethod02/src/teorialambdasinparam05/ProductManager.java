package teorialambdasinparam05;

//Tu vas a ser singleton
public class ProductManager {
	
	
	//ya no se pueden crear objetos de esto
	private ProductManager() {
		super();
	}

	public static Product getProduct(Types type) {
		return type.factoryMethod();
	}
}
