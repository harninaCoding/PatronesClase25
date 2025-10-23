package teorialambdaconparam06;

//Tu vas a ser singleton
public class ProductManager {
	
	
	//ya no se pueden crear objetos de esto
	private ProductManager() {
		super();
	}

	public static Product getProduct(Types type,Object value) {
		return type.factoryMethod(value);
	}
}
