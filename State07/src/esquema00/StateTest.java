package esquema00;
import org.junit.jupiter.api.Test;

class StateTest {

	@Test
	void test() {
		State initialState=new ConcreteStateA();
		Context context=new Context(initialState);
		//estado inicial A
		context.doThis();
		//estado transicion B
		context.doThis();
	}

}
