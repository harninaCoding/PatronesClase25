package esquema00;

public class ConcreteStateB implements State {

	public Context context;

	public void setContext(Context context) {
		this.context = context;
	}

	@Override
	public void doThis() {
		System.out.println("algo hago this tipo B");
	}
	
	@Override
	public void doThat() {
		System.out.println("algo hago that tipo B");

	}
}
