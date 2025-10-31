package esquema00;

public class Context{
	public State state;

	public Context(State state) {
		super();
		this.state = state;
		state.setContext(this);
	}

	public void changeState(State state) {
		this.state = state;
	}

	public void doThis() {
		state.doThis();
	}

	public void doThat() {
		state.doThat();
	}

}
