package esquema;

public class ConcreteComponent implements Component {

	@Override
	public void execute() {
		System.err.println("soy el componente concreto");
	}

}
