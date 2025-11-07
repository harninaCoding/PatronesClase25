package esquema;

public class ConcreteDecorator extends BaseDecorator {

	public ConcreteDecorator(Component wrappe) {
		super(wrappe);
	}

	@Override
	public void execute() {
		super.execute();
		//Esta es la nueva funcionalidad
		System.out.println("agrego esta funcionalidad concreta");
	}
}
