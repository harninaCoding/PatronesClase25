package ejercicio01Guerrero;

public class Fuerza extends Caracteristica {

	public Fuerza(Personaje personaje) {
		super(personaje);
	}

	@Override
	public int mostrarArmadura() {
		return personaje.mostrarArmadura();
	}

	@Override
	public int mostrarFuerza() {
		return personaje.mostrarFuerza()+25;
	}

	@Override
	public Personaje decrementaArmadura() {
		return personaje.decrementaArmadura();
	}

}
