package teoriabienparametrizada04;

public class ConcreteCreatorA implements Creator {

	private int mipropiedad;
	

	public ConcreteCreatorA(int valor) {
		super();
		this.mipropiedad = valor;
	}

	// dejar el factory method sin add parametros
	public Product factoryMethod() {
		return ConcreteProductA.getProduct(mipropiedad);

	}
	
	
}