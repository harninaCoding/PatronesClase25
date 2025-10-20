package teoria;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SingletonTest {

	@Test
	void testGetINSTANCIA() {
		Singleton instancia2 = Singleton.getINSTANCIA();
		Singleton instancia = instancia2;
		instancia=Singleton.getINSTANCIA();
		assertTrue(instancia==instancia2);
		//no se puede
//		Singleton sin=new Singleton();
	}

}
