package facadeejemplo01;

import facadeejemplo02.ImpresoraEspecial;

public class FacadeImpresora {
	public void imprimirDocumentoNormal(String texto) {
		new ImpresoraNormal(texto);
	}
	
}
