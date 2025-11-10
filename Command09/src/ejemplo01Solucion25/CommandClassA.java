package ejemplo01Solucion25;

public class CommandClassA implements Command{
	ClasA a;
	
	
	public CommandClassA(ClasA a) {
		super();
		this.a = a;
	}


	@Override
	public void execute() {
		this.a.transformaA();
		
	}

}
