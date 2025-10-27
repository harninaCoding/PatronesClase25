package adapteresquemasolucion01;

import org.junit.jupiter.api.Test;

import adapteresquemaproblema01.Data;
import adapteresquemaproblema01.Service;

class Client {

	@Test
	void test() {
		Data data=new Data();
		Service service=new Service();
		//El problema es que no esta adaptado
		//mis datos a los que necesita el servicio
		service.method(new Adapter().adapt(data));
	}

}
