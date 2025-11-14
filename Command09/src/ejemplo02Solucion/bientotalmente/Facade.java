package ejemplo02Solucion.bientotalmente;
public class Facade {
	Command command;

	public void setCommand(Command command) {
		this.command = command;
	}

	public void executeCommand() {
		if (command != null)
			command.execute();
	}
	

}