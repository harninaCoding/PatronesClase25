package ejercicio01Problema;

public class ServicioBBDD {

	public ServicioBBDD() {
		super();
		//Tarda un monton en arrancar
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void operation() {
		System.out.println("operado en la bbdd");
	}
}
