package teorialambdaconparam06;

import java.util.function.Function;
import java.util.function.Supplier;

public enum Types {
	
	A((valor)->{return new ConcreteProductA(valor);}),
	B((otro)->{return new ConcreteProductB(otro);}),
	C((valor)->{return new ConcreteProductC();});

	private Function<Object,Product> function;
	private Integer valor;
	private String otro;
	private Types(Function<Object,Product> supplier) {
		this.function = supplier;
	}

	public Product factoryMethod(Object valor) {
		return function.apply(valor);
	}
	
}
