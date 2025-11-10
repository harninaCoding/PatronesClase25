package ejercicio01Guerrero;

import org.junit.jupiter.api.Test;

class general {

	@Test
	void test() {
		Personaje guerrero=new Guerrero();
		System.out.println("fuerza:"+guerrero.mostrarFuerza());
		System.out.println("armadura: "+guerrero.mostrarArmadura());
		guerrero=new Armadura(guerrero);
		System.out.println("fuerza:"+guerrero.mostrarFuerza());
		System.out.println("armadura: "+guerrero.mostrarArmadura());
		guerrero=new Armadura(guerrero);
		System.out.println("fuerza:"+guerrero.mostrarFuerza());
		System.out.println("armadura: "+guerrero.mostrarArmadura());
		guerrero=new Fuerza(guerrero);
		System.out.println("fuerza:"+guerrero.mostrarFuerza());
		System.out.println("armadura: "+guerrero.mostrarArmadura());
		guerrero=new Fuerza(guerrero);
		System.out.println("fuerza:"+guerrero.mostrarFuerza());
		System.out.println("armadura: "+guerrero.mostrarArmadura());
	}

}
