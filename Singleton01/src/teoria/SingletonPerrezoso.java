package teoria;

public class SingletonPerrezoso {
	private int cosa;
	private static SingletonPerrezoso INSTANCIA;

	private SingletonPerrezoso() {
		super();
	}

	public int getCosa() {
		return cosa;
	}

	public void setCosa(int cosa) {
		this.cosa = cosa;
	}

	public static SingletonPerrezoso getINSTANCIA() {
		if(INSTANCIA==null)
			INSTANCIA=new SingletonPerrezoso();
		return INSTANCIA;
	}
	
	
}
