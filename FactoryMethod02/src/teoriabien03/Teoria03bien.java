package teoriabien03;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class Teoria03bien {

	@Test
	void test() {
		FactoryManager fm=new FactoryManager();
		ProductAbstract product = fm.getProduct(new ConcreteCreatorA());
		assertEquals(product.getClass(), ConcreteProductA.class);
	}

}
