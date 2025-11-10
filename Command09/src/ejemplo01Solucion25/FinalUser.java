package ejemplo01Solucion25;

import java.util.List;

public class FinalUser {

	// Con command
	public static void main(String[] args) {
		Client client = new Client();
		List<Command> comandos=List.of((Command)new CommandClassA(new ClasA()),
				(Command)new CommandClassB(new ClasB()),
				(Command)new CommandClassC(new ClassC(), "holita")
				);
		comandos.forEach(comando->{
			client.setCommand(comando);
			client.executeCommand();
		});
	}
}
