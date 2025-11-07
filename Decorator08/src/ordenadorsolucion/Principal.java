package ordenadorsolucion;

public class Principal {
    public static void main(String[] args) {
        Ordenador pc = new OrdenadorBase(400.0);
        pc = new Procesador(pc, "Ryzen 5 5600", 180.0);
        pc = new DiscoDuro(pc, "SSD NVMe", 1000, 75.0);
        pc = new MemoriaRam(pc, 16, 55.0);
        pc = new DiscoDuro(pc, "HDD", 2000, 60.0); // Se pueden encadenar y repetir

        System.out.println(pc.description());
        System.out.println("Coste total: " + pc.calculateCost() + " €");
    }
}
