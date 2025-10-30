package doraaprendeobservers;

public class Data {
	private int datoCambiante=5;
	private Utilizador utilizador;
	
	public Data(Utilizador utilizador) {
		super();
		this.utilizador = utilizador;
	}

	public int getDatoCambiante() {
		return datoCambiante;
	}

	//cuando un cambio
	public void setDatoCambiante(int datoCambiante) {
		this.datoCambiante = datoCambiante;
		utilizador.avisaCambio(datoCambiante);
	}
	
}
