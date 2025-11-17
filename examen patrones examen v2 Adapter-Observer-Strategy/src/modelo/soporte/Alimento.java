package modelo.soporte;

import java.util.Random;

public enum Alimento {
	hoja(7), pata(15), pan(12), azucar(14), plastico(1);

	int power;

	Alimento(int power) {
		this.power = power;
	}

	public static Alimento getRandomAlimento() {
		return Alimento.values()[new Random().nextInt(Alimento.values().length)];
	}

	public int getPower() {
		return power;
	}


}
