package tienda01;

//Estrategia de Descuento de Temporada
class DescuentoTemporada implements DescuentoStrategy {
 private double descuento;

 public DescuentoTemporada(double descuento) {
     this.descuento = descuento;
 }

 @Override
 public double aplicarDescuento(double precioOriginal) {
     // Lógica adicional para verificar si está en temporada de descuento
     // Suponiendo que esta es la temporada
     boolean esTemporada = true;
     if (esTemporada) {
         return precioOriginal - descuento;
     } else {
         return precioOriginal;
     }
 }
}