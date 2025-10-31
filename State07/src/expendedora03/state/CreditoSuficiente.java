package expendedora03.state;

//Estado CreditoSuficiente
class CreditoSuficiente implements EstadoMaquina {
 private MaquinaExpendedora maquina;

 public CreditoSuficiente(MaquinaExpendedora maquina) {
     this.maquina = maquina;
 }

 @Override
 public void insertarMoneda(int monto) {
     System.out.println("Ya hay suficiente crédito. Seleccione una bebida.");
 }

 @Override
 public void seleccionarBebida(String bebida) {
     System.out.println("Bebida " + bebida + " seleccionada.");
     maquina.setEstado(maquina.getEntregaProducto());
 }

 @Override
 public void dispensarProducto() {
     System.out.println("Por favor, seleccione una bebida primero.");
 }
}