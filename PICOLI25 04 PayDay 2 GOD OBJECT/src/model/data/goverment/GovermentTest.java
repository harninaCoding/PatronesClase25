package model.data.goverment;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import model.data.being.Being;

class GovermentTest {

	@Test
	void testPagarPoblacion() {
		int poblacionInicial=100;
		int edadMaxima=64;
		int demanda=40_000;
		int capital=(poblacionInicial*Being.vitalNecesity)*20;
		float incremento=.1f;
		Government government=new Government(poblacionInicial, edadMaxima);
		government.setCapital(capital);
		government.setProduccionSolicitada(demanda);
		//arrancamos el mundo
		
		int periodoActual=0;
		for (; periodoActual < 17; periodoActual++) {
			try {
				government.gestionarPeriodo(incremento);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		for (; periodoActual < 63; periodoActual++) {
			try {
				government.gestionarPeriodo(incremento);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
