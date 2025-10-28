package ejercicio01solucion;

import ejercicio01Problema.ServicioBBDD;

public class Client {
	ProxyServicioBBDD servicioBBDD;

	public Client() {
		super();
		servicioBBDD=new ProxyServicioBBDD();
		// hace mas cosas
		System.out.println("carga terminada");
	}

	public void operarEnOtroSitio() {
		System.out.println("no tiene que ver con la bbdd");
	}

	public void operarEnBBDD() {
		
		servicioBBDD.operation();
	}
}
