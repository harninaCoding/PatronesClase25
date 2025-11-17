package modelo.strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import modelo.insectos.Hormiga;
import modelo.soporte.Alimento;

public class Recolectora implements Comportamiento{

	List<Alimento> alimentos;
	
	
	public Recolectora() {
		super();
		alimentos = new ArrayList();
	}

	@Override
	public void hacerTarea(Hormiga hormiga) {
		hormiga.incrementaEdad(hormiga.incrementoVidaPorDefecto);
		alimentos.add(Alimento.getRandomAlimento());
	}
	public Optional<List<Alimento>> getAlimentos() {
		return Optional.of(alimentos);
	}

}
