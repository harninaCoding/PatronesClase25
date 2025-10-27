package facadeejemplo02bis;

/**

 */
public class PrincipalCliente {
	public static void main(String[] args) {

		// con fachada
		FacadeImpresora facadeImpresora = new FacadeImpresora();
		facadeImpresora.imprimirDocumentoNormal("texto");
		facadeImpresora.imprimirDocumentoEspecial("texto especial");

		// Sin fachada
		Impresora i2 = new Impresora();

		i2.setHoja("a4");

		i2.setColor(true);

		i2.setTipoDocumento("pdf");

		i2.setTexto("texto 2");

		i2.imprimirDocumento();

		Impresora i3 = new Impresora();

		i3.setHoja("a3");

		i3.setColor(false);

		i3.setTipoDocumento("excel");

		i3.setTexto("texto 3");

		i3.imprimirDocumento();

	}
}
