package teorialambdasinparam05;

import java.util.function.Supplier;

public enum Types {
	
	A(()->{return new ConcreteProductA();}),
	B(()->{return new ConcreteProductB();}),
	C(()->{return new ConcreteProductC();});

	private Supplier<Product> supplier;
	
	private Types(Supplier<Product> supplier) {
		this.supplier = supplier;
	}

	public Product factoryMethod() {
		return supplier.get();
	}
	
}
