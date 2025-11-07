package ordenadorsolucion;

public class MemoriaRam extends Componente {
    private final int gb;

    public MemoriaRam(Ordenador ordenador, int gb, double coste) {
        super(ordenador,coste);
        this.gb = gb;
    }
   
    @Override
    public String description() {
        return super.description() + " + RAM +"+gb+"dGB";
    }
}
