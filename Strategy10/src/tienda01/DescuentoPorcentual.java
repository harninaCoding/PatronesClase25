package tienda01;

//Estrategia de Descuento Porcentual
class DescuentoPorcentual implements DescuentoStrategy {
 private double porcentaje;

 public DescuentoPorcentual(double porcentaje) {
     this.porcentaje = porcentaje;
 }

 @Override
 public double aplicarDescuento(double precioOriginal) {
     return precioOriginal - (precioOriginal * porcentaje / 100);
 }
}