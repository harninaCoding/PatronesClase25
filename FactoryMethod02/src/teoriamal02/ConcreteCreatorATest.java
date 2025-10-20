package teoriamal02;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ConcreteCreatorATest {

	@Test
	void test() {
		ConcreteCreatorA creador=new ConcreteCreatorA();
		assertTrue(ConcreteProductB.class==creador.factoryMethod(2).getClass());
		assertTrue(creador.factoryMethod(2) instanceof ConcreteProductB);
	}

}
