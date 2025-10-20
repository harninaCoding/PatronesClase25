package solucion01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ClienteTest {

	@Test
	void test() {
		Creator creador = null;
		//coomo usuario elijo
		creador=new CreatorConcreteUno();
		//sotware cliente
		creador.factoryMethod();
		Product producto=creador.getProducto();
		System.out.println(producto.getClass());
		creador=new CreadorConcreteDos();
		creador.factoryMethod();
		producto=creador.getProducto();
		System.out.println(producto.getClass());
	}

}
