package esquema;

public class Test {
	Client client;

	public Test() {
		super();
		client=new Client(new ProxyService(new Service()));
		client.operation();
	}
	
	public static void main(String[] args) {
		new Test();
	}
}
