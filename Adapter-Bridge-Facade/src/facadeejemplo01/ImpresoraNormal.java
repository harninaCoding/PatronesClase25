package facadeejemplo01;

public class ImpresoraNormal extends Impresora {

	public ImpresoraNormal(String texto) {
		super();
		setColor(false);
		setHoja("A4");
		setTipoDocumento("PDF");
		setTexto(texto);
	}	
	
}
