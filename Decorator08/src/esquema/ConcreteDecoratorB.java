package esquema;

public class ConcreteDecoratorB extends BaseDecorator {

	public ConcreteDecoratorB(Component wrappe) {
		super(wrappe);
	}
	
	@Override
	public void execute() {
		super.execute();
		System.out.println("y tambien la funcioanlidad B");
	}

}
