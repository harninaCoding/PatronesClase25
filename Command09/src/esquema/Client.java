package esquema;

public class Client {
	public static void main(String[] args) {
		// el interruptor o el boton
		Invoker boton = new Invoker();
		Command copy = new CopyCommand(new Editor());
		boton.setCommand(copy);
		boton.executeCommand();
		/////////////////////
		Receiver receiver = new Receiver();
		Command receiverCommand = new CommandOne(receiver, "mi parametro");
		boton.setCommand(receiverCommand);
		boton.executeCommand();
	}
}
