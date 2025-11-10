package ejercicio01Guerrero;

public abstract class Caracteristica implements Personaje {
	Personaje personaje;
	
	public Caracteristica(Personaje personaje) {
		super();
		this.personaje = personaje;
	}

	@Override
	public Personaje degradaTotal() {
		return personaje.degradaTotal();
	}
	
	@Override
	public Personaje decrementaElemento() {
		System.out.println("Quiero degradar");
		return personaje;
	}
}
