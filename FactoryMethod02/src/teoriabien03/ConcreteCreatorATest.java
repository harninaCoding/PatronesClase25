package teoriabien03;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ConcreteCreatorATest {

	@Test
	void test() {
		FactoryManager mia=new FactoryManager();
		//el usuario elige
		assertTrue(ConcreteProductB.class
				==mia.getProduct(new ConcreteCreatorB()).getClass());
	}

}
