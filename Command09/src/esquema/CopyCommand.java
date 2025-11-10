package esquema;

public class CopyCommand implements Command {
	
	private Editor editor;

	public CopyCommand(Editor editor) {
		super();
		this.editor = editor;
	}

	@Override
	public void execute() {
		editor.doSomething();
	}

}
