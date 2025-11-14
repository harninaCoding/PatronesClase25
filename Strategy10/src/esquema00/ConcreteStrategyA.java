package esquema00;

public class ConcreteStrategyA implements Strategy {

	@Override
	public void doThis(Data data) {
		System.out.println("algo hago this tipo A");
		
	}

	@Override
	public void doThat(Data data) {
		System.out.println("algo hago that tipo A");
		
	}

}
