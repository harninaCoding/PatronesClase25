package ejercicio01solucion;

public class ProxyServicioBBDD {
	ServicioBBDD servicioBBDD;
	
	public void operation() {
		//de diez a doce no hago estas cosas
		servicioBBDD=new ServicioBBDD();
		servicioBBDD.operation();
	}
}
