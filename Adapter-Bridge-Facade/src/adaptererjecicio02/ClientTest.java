package adaptererjecicio02;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ClientTest {

	@Test
	void test() {
		Trifulnio trifulnio = new Trifulnio();
		trifulnio.numeroA = "232";
		trifulnio.numeroB = "12";
		Client client = new Client();
		client.treat(null);
	}

}
