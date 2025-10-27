package adapterejerciciosolucionparamtrizada02;

import org.junit.jupiter.api.Test;

import adaptererjecicio02.Client;
import adaptererjecicio02.Gorgete;
import adaptererjecicio02.Trifulnio;

class ClientTest {

	@Test
	void test() {
		Trifulnio trifulnio = new Trifulnio();
		trifulnio.numeroA = "232";
		trifulnio.numeroB = "12";
		Client client = new Client();
		Mapper<Trifulnio, Gorgete> mapper = (e->{
			Gorgete gorgete=new Gorgete();
			gorgete.numeroA=Integer.valueOf(e.numeroA);
			gorgete.numeroB=Integer.valueOf(e.numeroB);
			return gorgete;
		});
		client.treat(mapper.map(trifulnio));
	}

}
