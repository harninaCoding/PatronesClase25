package facadeesquema00;

public class Facade {
	public void doSomething() {
		new ComplicadaA().doA();
		new ComplicadaB().doB();
	}
}
