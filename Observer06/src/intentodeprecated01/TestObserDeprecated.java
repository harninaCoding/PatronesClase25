package intentodeprecated01;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Observer;

import org.junit.jupiter.api.Test;

class TestObserDeprecated {

	@Test
	void test() {
		Consumer observer=new Consumer();
		System.out.println(observer.mio);
		Proveedor proveedor=new Proveedor(observer);
		proveedor.setArg("pena");
		System.out.println(observer.mio);
	}

}
