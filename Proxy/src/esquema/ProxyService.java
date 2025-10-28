package esquema;

public class ProxyService implements IService {

	IService IService;
	
	
	public ProxyService(IService iService) {
		super();
		IService = iService;
	}

	public void checkAccess() {
		
	}
	@Override
	public void operation() {
		System.out.println("soy el proxy");
		IService.operation();
	}

}
