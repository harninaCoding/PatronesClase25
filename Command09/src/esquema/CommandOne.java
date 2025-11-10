package esquema;


public class CommandOne implements Command {
	private Receiver receiver;
	private String params;

	public CommandOne(Receiver receiver, String params) {
		super();
		this.receiver = receiver;
		this.params = params;
	}

	@Override
	public void execute() {
		receiver.operation(params);
	}

}
