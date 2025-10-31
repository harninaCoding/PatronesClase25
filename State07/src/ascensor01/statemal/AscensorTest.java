package ascensor01.statemal;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AscensorTest {

	@Test
	void test() {
		//comeinza en la planta baja
		Ascensor ascensor=new Ascensor();
		//no puede bajar
		ascensor.bajar();
		ascensor.subir();
		//ahora esta en entreplanta
		ascensor.subir();
		for (int i = 0; i < 9; i++) {
			ascensor.subir();
		}
		ascensor.subir();
		ascensor.bajar();
		ascensor.subir();
		ascensor.subir();
	}

}
