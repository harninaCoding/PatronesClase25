package ejercicio01Problema;

public class Client {
	ServicioBBDD servicioBBDD;

	public Client() {
		super();
		System.out.println("arrancando el servicio de bbdd");
		servicioBBDD=new ServicioBBDD();
		//hace mas cosas
		System.out.println("carga terminada");
	}
	
	public void operarEnOtroSitio() {
		System.out.println("no tiene que ver con la bbdd");
	}
	
	public void operarEnBBDD() {
		System.out.println("operando en base ");
		servicioBBDD.operation();
	}
}
