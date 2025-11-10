package ejemplo01Solucion25;

public class CommandClassB implements Command {
	ClasB b;
	
	
	public CommandClassB(ClasB b) {
		super();
		this.b = b;
	}


	@Override
	public void execute() {
		b.transforB();

	}

}
