package teoriabienparametrizada04;

public class prueba {
	public static void main(String args[]) {
		ProductManager productManager = new ProductManager();
		//Debo conocer los constructores de los creadores
		//el cliente si que sabe que tipo quiere crear
		Product producto = productManager.createProduct(new ConcreteCreatorA(3));
		producto.operacion();
		System.out.println(producto.quienSoy());
		// este casteo lo hago para que se vea que funciona. no deberiamos tener acceso
		// a elementos propios casteando
		System.out.println(((ConcreteProductA) producto).getMipropiedad());
		ConcreteProductA concreteProductA=(ConcreteProductA) producto;
		producto = productManager.createProduct(new ConcreteCreatorB());
		producto.operacion();
		System.out.println(producto.quienSoy());
	}
}
