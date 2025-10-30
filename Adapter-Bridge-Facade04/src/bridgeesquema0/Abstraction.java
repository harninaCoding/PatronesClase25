package bridgeesquema0;

public class Abstraction {
	private Implementation i;
	
	public Abstraction(Implementation i) {
		super();
		this.i = i;
	}

	public void feature1() {
		i.method1();
	}
	
	public void feature2() {
		i.method2();
		i.method3();
	}
}
