package teoriabienparametrizada04;

public class ProductManager {

	public Product createProduct(Creator creator) {
		return creator.factoryMethod();
	}
}
