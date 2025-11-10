package ejemplo01Solucion25;

//eL INVOKER ES EL INTERRUPTOR
public class Client implements Invoker{

	Command command;
	@Override
	public void setCommand(Command command) {
		this.command=command;
		
	}

	@Override
	public void executeCommand() {
		this.command.execute();
		
	}
}
