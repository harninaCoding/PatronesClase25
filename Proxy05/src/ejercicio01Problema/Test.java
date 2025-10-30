package ejercicio01Problema;

public class Test {
	public static void main(String[] args) {
		Client client = new Client();
		// hago muchas cosas
		client.operarEnOtroSitio();
		// y tardo mucho en comenzar a trabajar con la bbdd
		// igual ni siquiera lo hago
		client.operarEnBBDD();
		//debemos crear un proxy
	}
}
