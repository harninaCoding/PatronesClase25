package facadeejemplo02;

public class FacadeImpresora {
	public void imprimirDocumentoNormal(String texto) {
		new ImpresoraNormal(texto);
	}
	public void imprimirDocumentoEspecial(String texto) {
		new ImpresoraEspecial(texto);
	}
}
