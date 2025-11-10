package ejemplo01Solucion25;

public class CommandClassC implements Command {

	ClassC c;
	String mensaje;
	
	
	public CommandClassC(ClassC c, String mensaje) {
		super();
		this.c = c;
		this.mensaje = mensaje;
	}


	@Override
	public void execute() {
		System.out.println(this.c.dameMensajeEnMAyusculas(mensaje));

	}

}
