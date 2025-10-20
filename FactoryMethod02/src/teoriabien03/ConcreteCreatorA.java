package teoriabien03;

public class ConcreteCreatorA extends CreatorAbstract {

	@Override
	public ProductAbstract factoryMethod() {
			return new ConcreteProductA();
	}
}
