package expendedora03.state;

//Estado EsperandoMoneda
class EsperandoMoneda implements EstadoMaquina {
 private MaquinaExpendedora maquina;

 public EsperandoMoneda(MaquinaExpendedora maquina) {
     this.maquina = maquina;
 }

 @Override
 public void insertarMoneda(int monto) {
     maquina.agregarSaldo(monto);
     System.out.println("Moneda insertada. Saldo actual: " + maquina.getSaldo());
     if (maquina.getSaldo() >= maquina.getPrecioBebida()) {
         maquina.setEstado(maquina.getCreditoSuficiente());
     }
 }

 @Override
 public void seleccionarBebida(String bebida) {
     System.out.println("Saldo insuficiente. Por favor, inserte más monedas.");
 }

 @Override
 public void dispensarProducto() {
     System.out.println("Por favor, seleccione una bebida primero.");
 }
}