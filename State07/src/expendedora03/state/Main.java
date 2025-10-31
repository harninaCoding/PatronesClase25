package expendedora03.state;

//Ejemplo de uso
public class Main {
 public static void main(String[] args) {
     MaquinaExpendedora maquina = new MaquinaExpendedora();

     maquina.insertarMoneda(50);  // Estado: EsperandoMoneda
     maquina.seleccionarBebida("Coca-Cola"); // No hay suficiente saldo

     maquina.insertarMoneda(50);  // Estado: CreditoSuficiente
     maquina.seleccionarBebida("Coca-Cola"); // Selecciona y pasa a entrega

     maquina.dispensarProducto();  // Estado: EntregaProducto y vuelta a EsperandoMoneda
 }
}

