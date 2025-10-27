package bridgeesquema0;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class testBridge {

	@Test
	void test() {
	Abstraction abstraction=new Abstraction(new MyFirstConcreteImplementation());
	abstraction.feature1();
	Abstraction abstraction2=new Abstraction(new MySecondConcreteImplementation());
	abstraction2.feature1();
	}

}
