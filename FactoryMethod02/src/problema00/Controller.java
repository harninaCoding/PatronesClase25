package problema00;

public class Controller {

	public Object giveMe(int tipo) {
		switch (tipo) {
		case 1:
			return new ProductoA();
		case 2:
			return new ProductoB();
		case 3:
			return new ProductoC();
		default:
			return null;
		}
	}
}
