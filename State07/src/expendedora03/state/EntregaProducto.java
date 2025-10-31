package expendedora03.state;

//Estado EntregaProducto
class EntregaProducto implements EstadoMaquina {
 private MaquinaExpendedora maquina;

 public EntregaProducto(MaquinaExpendedora maquina) {
     this.maquina = maquina;
 }

 @Override
 public void insertarMoneda(int monto) {
     System.out.println("Espere a que se entregue el producto antes de insertar más monedas.");
 }

 @Override
 public void seleccionarBebida(String bebida) {
     System.out.println("Ya se está entregando un producto.");
 }

 @Override
 public void dispensarProducto() {
     System.out.println("Dispensando bebida...");
     int cambio = maquina.getSaldo() - maquina.getPrecioBebida();
     if (cambio > 0) {
         System.out.println("Devolviendo cambio: " + cambio);
     }
     maquina.restablecerSaldo();
     maquina.setEstado(maquina.getEsperandoMoneda());
 }
}