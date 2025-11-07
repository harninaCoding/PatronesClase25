package esquema;

public class BaseDecorator implements Component {

	private Component wrappe;

	public BaseDecorator(Component wrappe) {
		super();
		this.wrappe = wrappe;
	}

	@Override
	public void execute() {
		wrappe.execute();
	}

}
