package modelo.adapter;

import modelo.insectos.*;
import modelo.soporte.HormigaData;

public class HormigaAdapter implements Adapter<Hormiga, HormigaData> {

	@Override
	public HormigaData convert(Hormiga hormiga) throws Exception {
		return new HormigaData(hormiga.getAlimentos(), hormiga.getVida(), hormiga.getId());
	}

}
