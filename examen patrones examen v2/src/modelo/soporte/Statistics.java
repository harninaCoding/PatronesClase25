package modelo.soporte;

import java.util.ArrayList;
import java.util.List;

public class Statistics {

    private List<HormigaData> data;

    public Statistics() {
        this.data = new ArrayList();
    }

    public void addData(HormigaData hormigaData){
        data.add(hormigaData);
    }

    public Double getCurrentMediaAlimento(){
        return data.stream().mapToDouble((data)->{return data.getMediaAlimentos();}).average().getAsDouble();
    }

    public double getCurrentIndiceGlobal(){
        return data.stream().mapToDouble((data)->{return data.getIndiceProductividad();}).average().getAsDouble();
    }
}
