package esquema00;

public class ConcreteStrategyB implements Strategy {


	@Override
	public void doThis(Data data) {
		System.out.println("algo hago this tipo b");
		
	}

	@Override
	public void doThat(Data data) {
		System.out.println("algo hago that tipo b");
		
	}
}
