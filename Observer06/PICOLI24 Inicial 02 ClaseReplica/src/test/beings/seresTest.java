package test.beings;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import model.data.being.Adult;
import model.data.being.Being;
import model.data.being.Young;
import utiles.Utiles;

class seresTest {
	@Test	
	void testVida() {
		//activa o desactiva los mensajes 
		Utiles.active=false;
		Being being=new Young(100f);
		Utiles.printLog(being.toString());
		Utiles.printLog("esperanza vida"+being.getLifeExpectancy());
		Utiles.printLog(" necesidad vital"+being.getVitalNecesity());
		for (int i = 0; i < 120&&being.isAlive(); i++) {
			if(being.live(100))
				Utiles.printLogN(" "+being.getCurrentAge());
			//SONDEO o POLLING preguntar todo el tiempo si ha
			//habido un cambio
			if(being.becomeAdult()) {
				Utiles.printLog();
				being=new Adult(being);
				Utiles.printLog(being.toString());
			}
			if(being.becomeOlder()){
				Utiles.printLog();
				being=new Being(being);
				Utiles.printLog("anciano "+being.toString());
			}
		}
		Utiles.printLog();
		Utiles.printLog("esperanza final "+being.getLifeExpectancy());
	}
	@Test
	void testalimentacion() {
		Being being=new Young(100f);
		Utiles.printLog(being.toString());
		float esperanzaVidaInicial = being.getLifeExpectancy();
		Utiles.printLog("esperanza vida"+esperanzaVidaInicial);
		Utiles.printLog(" necesidad vital"+being.getVitalNecesity());
		int sueldo = 30;
		for (int i = 0; i < 120&&being.isAlive(); i++) {
			if(being.live(sueldo))
				Utiles.printLogN(" "+being.getCurrentAge());
			//SONDEO o POLLING preguntar todo el tiempo si ha
			//habido un cambio
			if(being.becomeAdult()) {
				Utiles.printLog();
				being=new Adult(being);
				Utiles.printLog(being.toString());
			}
			if(being.becomeOlder()){
				Utiles.printLog();
				being=new Being(being);
				Utiles.printLog("anciano "+being.toString());
			}
		}
		Utiles.printLog();
		Utiles.printLog("esperanza final "+being.getLifeExpectancy());
		float i = being.getVitalNecesity()/sueldo;
		float f = esperanzaVidaInicial/i;
		float esperanzaVida = being.getLifeExpectancy();
		assertTrue(f<esperanzaVida);
	}
}
