package adapterejercicioaolucion02;

import org.junit.jupiter.api.Test;

import adaptererjecicio02.Client;
import adaptererjecicio02.Trifulnio;

class ClientTest {

	@Test
	void test() {
		Trifulnio trifulnio = new Trifulnio();
		trifulnio.numeroA = "232";
		trifulnio.numeroB = "12";
		Client client = new Client();
		client.treat(new AdapterTrifulnio2Gorgete().convert(trifulnio));
	}

}
