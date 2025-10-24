package telescope01;

import org.junit.jupiter.api.Test;

class PersonaTest {

	@Test
	void test() {
		Persona persona=new Persona.Builder(1, "Luis", "Goenaga").build();
		Persona persona1=new Persona.Builder(1, "Luis", "Goenaga").phone("67").build();
		Persona persona2=new Persona.Builder(1, "Luis", "Goenaga").color("pink").build();
		Persona persona3=new Persona.Builder(1, "Luis", "Goenaga").color("pink").phone("55").build();
	}
}
