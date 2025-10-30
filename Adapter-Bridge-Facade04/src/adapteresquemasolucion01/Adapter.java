package adapteresquemasolucion01;

import adapteresquemaproblema01.ClientBehaviour;
import adapteresquemaproblema01.Data;
import adapteresquemaproblema01.SpecialData;

public class Adapter implements ClientBehaviour {

	@Override
	public SpecialData adapt(Data data) {
		return convert(data);
	}

	private SpecialData convert(Data data) {
		// TODO Auto-generated method stub
		return null;
	}

}
