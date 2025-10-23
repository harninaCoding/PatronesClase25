package teorialambdasinparam05;

public class Prueba {
public static void main(String[] args) {
	Product product=ProductManager.getProduct(Types.A);
	System.out.println(product.quienSoy());
	product=ProductManager.getProduct(Types.B);
	System.out.println(product.quienSoy());
	product=ProductManager.getProduct(Types.C);
	System.out.println(product.quienSoy());
}
}
