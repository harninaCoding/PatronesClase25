package expendedora03.state;

//Interfaz EstadoMaquina
interface EstadoMaquina {
 void insertarMoneda(int monto);
 void seleccionarBebida(String bebida);
 void dispensarProducto();
}