package modelo.soporte;

import java.util.List;

public class HormigaData {
    List<Alimento> alimentos;
    int vida;
    long id;

    public HormigaData(List<Alimento> alimentos, int vida, long id) {
        this.alimentos = alimentos;
        this.vida = vida;
        this.id = id;
    }

    public Double getMediaAlimentos(){
        return alimentos.stream().mapToInt((alimento)->{return alimento.getPower();}).average().getAsDouble();
    }

    public float getIndiceProductividad(){
        return alimentos.stream().mapToInt((alimento)->{return alimento.getPower();}).sum()/(float)vida;
    }
}
