package test.goverment;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.data.goverment.Goverment;

class GovermentTest {

	//SUT Subject Under Test
	
	private Goverment state;

	@BeforeEach
	void setUp() {
		state = new Goverment(10,80);
	}

	@Test
	void testAncientChange() {
		assertEquals(10,state.getYoungs().size());
		state.developWorld(20);
		for (int i = 0; i < 4; i++) {
			System.out.println("la decada "+(i*10+20));
			state.developWorld(10);
			assertEquals(0,state.getYoungs().size());
			assertEquals(10,state.getAdults().size());
			assertEquals(0,state.getAncients().size());
		}
		assertEquals(61,state.getAdults().get(0).getCurrentAge());
		state.developWorld(4);
		assertEquals(0,state.getYoungs().size());
		assertEquals(0,state.getAdults().size());
		assertEquals(10,state.getAncients().size());
		state.developWorld(14);
		assertEquals(0,state.getYoungs().size());
		assertEquals(0,state.getAdults().size());
		assertEquals(10,state.getAncients().size());
		state.developWorld(1);
		assertEquals(0,state.getYoungs().size());
		assertEquals(0,state.getAdults().size());
		assertEquals(0,state.getAncients().size());
	}
	@Test
	void testYoung() {
		int size = state.getYoungs().size();
		state.developWorld(17);
		assertTrue(size>=state.getYoungs().size());
		assertTrue(state.getAdults().size()==0);
		state.developWorld(1);
		assertTrue(state.getAdults().size()>0);
		assertEquals(0,state.getYoungs().size());
		assertEquals(10, state.getAdults().size());
		int x = state.getAdults().size()+state.getYoungs().size();
		System.out.println(x);
		state.developWorld(3);
	}
}
