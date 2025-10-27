package adapterejercicioaolucion02;

import adaptererjecicio02.Gorgete;
import adaptererjecicio02.Trifulnio;

public class AdapterTrifulnio2Gorgete {

	public Gorgete convert(Trifulnio trifulnio) {
		Gorgete gorgete=new Gorgete();
		gorgete.numeroA=Integer.valueOf(trifulnio.numeroA);
		gorgete.numeroB=Integer.valueOf(trifulnio.numeroB);
		return gorgete;
	}
}
