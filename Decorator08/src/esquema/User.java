package esquema;

public class User {
public static void main(String[] args) {
	ConcreteComponent component=new ConcreteComponent();
	component.execute();
	ConcreteDecorator decorator=new ConcreteDecorator(component);
	decorator.execute();
	ConcreteDecoratorB decoratorB= new ConcreteDecoratorB(decorator);
	decoratorB.execute();
}
}
