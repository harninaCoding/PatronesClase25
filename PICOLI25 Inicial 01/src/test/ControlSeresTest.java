package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.jupiter.api.Test;

import model.data.being.Adult;
import model.data.being.Being;
import model.data.being.ControlBeing;
import model.data.being.Young;


class ControlSeresTest {
	ControlBeing controlSer=new ControlBeing();
	Being ser,otro;
	@Test
	void testMenorAborto() {
		int mayor=18;
		ser = controlSer.createBeing(mayor+1);
		for (int i = 0; i < mayor; i++) {
			if(ser instanceof Young) {
				int vitalNecesity = ser.getVitalNecesity()/4;
				ser.live(vitalNecesity);
			}
			otro=controlSer.controlAges(ser);
		}
		assertFalse(ser.isAlive());
	}
	@Test
	void testMenorAAdulto() {
		int mayor=18;
		ser = controlSer.createBeing(mayor+1);
		for (int i = 0; i < mayor-1; i++) {
			ser.live(ser.getVitalNecesity());
			otro=controlSer.controlAges(ser);
			assertEquals(otro,ser);
		}
		ser=otro;
		ser.live(ser.getVitalNecesity());
		//se have mayor
		otro=controlSer.controlAges(ser);
		assertNotEquals(otro,ser);
		assertEquals(Adult.class,otro.getClass());
	}
	@Test
	void testAdultoASer() {
		int anciano=65;
		ser = controlSer.createBeing(anciano+1);
		for (int i = 0; i < anciano-1; i++) {
			ser.live(ser.getVitalNecesity());
			ser=controlSer.controlAges(ser);
		}
		otro = controlSer.controlAges(ser);
		assertEquals(otro,ser);
		assertEquals(otro.getClass(),Adult.class);
		//pasa a anciano
		ser.live(ser.getVitalNecesity());
		otro = controlSer.controlAges(ser);
		assertNotEquals(otro,ser);
		assertEquals(otro.getClass(),Being.class);
		
	}
}
