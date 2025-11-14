package tienda01;

//Ejemplo de uso
public class Main {
 public static void main(String[] args) {
     Producto producto = new Producto("Televisor", 1000.0);

     // Estrategia de descuento fijo
     producto.setDescuentoStrategy(new DescuentoFijo(50.0));
     System.out.println("Precio con descuento fijo: " + producto.calcularPrecioFinal());

     // Estrategia de descuento porcentual
     producto.setDescuentoStrategy(new DescuentoPorcentual(10.0));
     System.out.println("Precio con descuento porcentual: " + producto.calcularPrecioFinal());

     // Estrategia de descuento de temporada
     producto.setDescuentoStrategy(new DescuentoTemporada(200.0));
     System.out.println("Precio con descuento de temporada: " + producto.calcularPrecioFinal());
 }
}
