package modelo.strategy;

import java.util.List;
import java.util.Optional;

import modelo.insectos.Hormiga;
import modelo.soporte.Alimento;

public interface Comportamiento {
	public void hacerTarea(Hormiga hormiga);
	public Optional<List<Alimento>> getAlimentos();
}
