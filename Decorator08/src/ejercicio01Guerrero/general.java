package ejercicio01Guerrero;

import org.junit.jupiter.api.Test;

class general {

	@Test
	void test() {
		Guerrero guerrero=new Guerrero();
		System.out.println(guerrero.mostrarFuerza());
		System.out.println(guerrero.mostrarArmadura());
	}

}
