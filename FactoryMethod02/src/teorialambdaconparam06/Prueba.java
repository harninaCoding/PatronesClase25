package teorialambdaconparam06;

public class Prueba {
public static void main(String[] args) {
	Product product=ProductManager.getProduct(Types.A,3);
	System.out.println(product.quienSoy());
	product=ProductManager.getProduct(Types.B,"liando");
	System.out.println(product.quienSoy());
	product=ProductManager.getProduct(Types.C,3);
	System.out.println(product.quienSoy());
}
}
