package facadeejemplo02;

public class ImpresoraEspecial extends Impresora {
	public ImpresoraEspecial(String texto) {
		super();
		setColor(false);
		setHoja("A3");
		setTipoDocumento("excel");
		setTexto(texto);
	}	
}
