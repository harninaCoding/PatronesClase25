package test.beings;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.data.being.Being;

public class YoungTest {
	private Being being;
	int adult = 18;
	@BeforeEach
	public void setUp() {
		float lifeExpectancy = 100; // Define un valor de necesidad vital para la prueba
		being = new Being(lifeExpectancy);
	}
	private void growBecomeAdult(int foodAmount) {
		for (int i = 0; i <= adult; i++) {
			being.live(foodAmount);
		}
	}

	@Test
	public void testGrowFullGrowth() {
		int foodAmount = 100; // Igual a la necesidad vital
		growBecomeAdult(foodAmount);
		assertTrue(being.isAlive());
	}

	@Test
	public void testGrowPartialGrowth() {
		int foodAmount = 50; // La mitad de la necesidad vital
		growBecomeAdult(foodAmount);
		assertFalse(being.isAlive());
	}

	@Test
	public void testGrowNoGrowth() {
		int foodAmount = 00; // Sin alimento
		growBecomeAdult(foodAmount);
		assertFalse(being.isAlive());
	}

	@Test
	public void testGrowNegativeFoodAmount() {
		int foodAmount = -5; // Cantidad negativa de alimento
		growBecomeAdult(foodAmount);
		assertFalse(being.isAlive());
	}
}
