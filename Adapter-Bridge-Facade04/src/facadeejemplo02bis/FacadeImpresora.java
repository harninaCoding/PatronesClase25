package facadeejemplo02bis;

public class FacadeImpresora {
	public void imprimirDocumentoNormal(String texto) {
		Impresora impresora = new Impresora();
		impresora.setColor(false);
		impresora.setHoja("A4");
		impresora.setTipoDocumento("PDF");
		impresora.setTexto(texto);
		impresora.imprimirDocumento();
	}
	public void imprimirDocumentoEspecial(String texto) {
		Impresora impresora = new Impresora();
		impresora.setColor(false);
		impresora.setHoja("A3");
		impresora.setTipoDocumento("excel");
		impresora.setTexto(texto);
		impresora.imprimirDocumento();
	}
}
