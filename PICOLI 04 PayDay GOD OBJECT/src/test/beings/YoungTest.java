package test.beings;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.data.being.Being;
import model.data.being.Young;

public class YoungTest {
	private Young young;

	@BeforeEach
	public void setUp() {
		young = new Young(new Being());
	}

	@Test
	public void testGrowFullGrowth() {
		int foodAmount = 100; // Igual a la necesidad vital
		young.grow(foodAmount);
		assertEquals(5.55, young.getDevelopmentFactor(), 0.01,
				"El desarrollo debe aumentar en 5.55 con crecimiento completo.");
	}

	@Test
	public void testGrowPartialGrowth() {
		int foodAmount = 50; // La mitad de la necesidad vital
		young.grow(foodAmount);
		assertEquals(2.775, young.getDevelopmentFactor(), 0.01,
				"El desarrollo debe aumentar proporcionalmente con crecimiento parcial.");
	}

	@Test
	public void testGrowNoGrowth() {
		int foodAmount = 00; // Sin alimento
		young.grow(foodAmount);
		assertEquals(0.0, young.getDevelopmentFactor(), "El desarrollo no debe cambiar sin alimento.");
	}

	@Test
	public void testGrowNegativeFoodAmount() {
		int foodAmount = -5; // Cantidad negativa de alimento
		young.grow(foodAmount);
		assertEquals(0.0, young.getDevelopmentFactor(),
				"El desarrollo no debe cambiar con cantidad negativa de alimento.");
	}
}
