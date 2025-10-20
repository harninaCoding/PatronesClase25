package teoriamal02;

public class ConcreteCreatorA extends CreatorAbstract {

	@Override
	public ProductAbstract factoryMethod(int selector) {
		switch (selector) {
		case 1:
			return new ConcreteProductA();
		case 2:
			return new ConcreteProductB();
		case 3:
			return new ConcreteProductC();
		}
		return null;
	}
}
