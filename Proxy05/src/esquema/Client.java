package esquema;

public class Client {
	IService iService;

	public Client(IService iService) {
		super();
		this.iService = iService;
	}

	public void operation() {
		iService.operation();
	}
	
	
}
