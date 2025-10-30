package bridgeejemplo00;

public class RemoteBasic {
	
	IModeloTV modeloTV;
	
	public RemoteBasic(IModeloTV modeloTV) {
		super();
		this.modeloTV = modeloTV;
	}

	public void setModeloTV(IModeloTV modeloTV) {
		this.modeloTV = modeloTV;
	}

	public void botonUno() {
		modeloTV.encender();
		
	}

	public void botonDos() {
		modeloTV.apagar();
	}
}
