package expendedora03.state;

//Clase MaquinaExpendedora, que maneja los estados y transiciones
class MaquinaExpendedora {
 private EstadoMaquina estadoActual;
 private int saldo = 0;
 private final int PRECIO_BEBIDA = 100;

 private final EstadoMaquina esperandoMoneda = new EsperandoMoneda(this);
 private final EstadoMaquina creditoSuficiente = new CreditoSuficiente(this);
 private final EstadoMaquina entregaProducto = new EntregaProducto(this);

 public MaquinaExpendedora() {
     this.estadoActual = esperandoMoneda;
 }

 public void setEstado(EstadoMaquina nuevoEstado) {
     this.estadoActual = nuevoEstado;
 }

 public EstadoMaquina getEsperandoMoneda() { return esperandoMoneda; }
 public EstadoMaquina getCreditoSuficiente() { return creditoSuficiente; }
 public EstadoMaquina getEntregaProducto() { return entregaProducto; }

 public int getSaldo() { return saldo; }
 public void agregarSaldo(int monto) { saldo += monto; }
 public void restablecerSaldo() { saldo = 0; }

 public int getPrecioBebida() { return PRECIO_BEBIDA; }

 public void insertarMoneda(int monto) {
     estadoActual.insertarMoneda(monto);
 }

 public void seleccionarBebida(String bebida) {
     estadoActual.seleccionarBebida(bebida);
 }

 public void dispensarProducto() {
     estadoActual.dispensarProducto();
 }
}