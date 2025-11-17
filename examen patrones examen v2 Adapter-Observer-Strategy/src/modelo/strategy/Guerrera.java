package modelo.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import modelo.insectos.Hormiga;
import modelo.soporte.Alimento;

public class Guerrera implements Comportamiento {
	List<Integer> luchas;

	public Guerrera() {
		super();
		luchas=new ArrayList<>();
	}

	@Override
	public void hacerTarea(Hormiga hormiga) {
		hormiga.incrementaEdad(hormiga.getVida()/4);
		int tiempoMaximoLucha=100;
		luchas.add(new Random().nextInt(tiempoMaximoLucha));
		
	}

	@Override
	public Optional<List<Alimento>> getAlimentos() {
		return Optional.empty();
	}

}
