package adapteresquemaproblema01;

import org.junit.jupiter.api.Test;

class Client {

	@Test
	void test() {
		Data data=new Data();
		Service service=new Service();
		//El problema es que no esta adaptado
		//mis datos a los que necesita el servicio
//		service.method(data);
	}

}
