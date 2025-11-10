package ejercicio01Guerrero;

public class Armadura extends Caracteristica {

	public Armadura(Personaje personaje) {
		super(personaje);
	}

	@Override
	public int mostrarArmadura() {
		return personaje.mostrarArmadura()+50;
	}

	@Override
	public int mostrarFuerza() {
		return personaje.mostrarFuerza();
	}

	@Override
	public Personaje decrementaArmadura() {
		return personaje;
	}

}
