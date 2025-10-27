package bridgeejemplo00;

import org.junit.jupiter.api.Test;

class ClienteTest {

	@Test
	void test() {
		RemoteBasic remoteBasic = new RemoteBasic(new WachifiTV());
		remoteBasic.botonUno();
		//usando el set (pero entonces ya no es un bridge)
		remoteBasic.setModeloTV(new GloomberTV());
		remoteBasic.botonUno();
	}

}
