package ejercicio01Guerrero;

public class Guerrero implements Personaje {
	//no hay propiedades, luego no es una clase
	// pero me obliga a aplicar Decorator
	
	@Override
	public int mostrarArmadura() {
		return 0;
	}

	@Override
	public Personaje decrementaElemento() {
		return this;
	}
	
	@Override
	public int mostrarFuerza() {
		return 0;
	}
	
	@Override
	public Personaje degradaTotal() {
		return this;
	}

	@Override
	public Personaje decrementaArmadura() {
		return this;
	}
}
