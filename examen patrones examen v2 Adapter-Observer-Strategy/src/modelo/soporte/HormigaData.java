package modelo.soporte;

import java.util.List;
import java.util.Optional;

public class HormigaData {
	List<Alimento> alimentos;
	int vida;
	long id;

	public HormigaData(Optional<List<Alimento>> alimentos, int vida, long id) throws Exception {
		if (!alimentos.isPresent())	throw new Exception();
		this.alimentos = alimentos.get();
		this.vida = vida;
		this.id = id;
	}

	public Double getMediaAlimentos() {
		return alimentos.stream().mapToInt((alimento) -> {
			return alimento.getPower();
		}).average().getAsDouble();
	}

	public float getIndiceProductividad() {
		return alimentos.stream().mapToInt((alimento) -> {
			return alimento.getPower();
		}).sum() / (float) vida;
	}
}
