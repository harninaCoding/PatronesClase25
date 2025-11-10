package esquema;

public class Invoker {
	Command command;

	public void setCommand(Command command) {
		this.command = command;
	}

	public void executeCommand() {
		if (command != null)
			command.execute();
	}
}
