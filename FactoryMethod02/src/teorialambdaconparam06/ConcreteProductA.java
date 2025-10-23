package teorialambdaconparam06;

public class ConcreteProductA extends Product {

	private int cosa;
	
	
	public ConcreteProductA(Object valor) {
		super();
		this.cosa = (int) valor;
	}


	@Override
	public void operacion() {
		// TODO Auto-generated method stub
		System.out.println("operacion del producto " + this.getClass().getName());
	}

}