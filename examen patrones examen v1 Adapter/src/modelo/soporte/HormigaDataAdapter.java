package modelo.soporte;

import modelo.insectos.Hormiga;

public class HormigaDataAdapter {
	
	//Es posible hacerlo no estatico
	public static HormigaData convert(Hormiga hormiga) {
		return new HormigaData(hormiga.getAlimentos(), hormiga.getVida(), hormiga.getId());
	}
}
