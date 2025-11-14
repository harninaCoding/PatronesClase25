package tienda01;

//Estrategia de Descuento Fijo
class DescuentoFijo implements DescuentoStrategy {
 private double descuento;

 public DescuentoFijo(double descuento) {
     this.descuento = descuento;
 }

 @Override
 public double aplicarDescuento(double precioOriginal) {
     return precioOriginal - descuento;
 }
}