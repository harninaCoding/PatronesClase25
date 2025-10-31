package expendedora03.problema;

public class MaquinaExpendedora {
    private int saldo = 0;
    private final int PRECIO_BEBIDA = 100;
    private String estadoActual = "EsperandoMoneda";

    public void insertarMoneda(int monto) {
        if (estadoActual.equals("EsperandoMoneda")) {
            saldo += monto;
            System.out.println("Moneda insertada. Saldo actual: " + saldo);
            if (saldo >= PRECIO_BEBIDA) {
                estadoActual = "CreditoSuficiente";
            }
        } else if (estadoActual.equals("CreditoSuficiente")) {
            System.out.println("Ya hay suficiente crédito. Seleccione una bebida.");
        } else if (estadoActual.equals("EntregaProducto")) {
            System.out.println("Espere a que se entregue el producto antes de insertar más monedas.");
        }
    }

    public void seleccionarBebida(String bebida) {
        if (estadoActual.equals("EsperandoMoneda")) {
            System.out.println("Saldo insuficiente. Por favor, inserte más monedas.");
        } else if (estadoActual.equals("CreditoSuficiente")) {
            System.out.println("Bebida " + bebida + " seleccionada.");
            estadoActual = "EntregaProducto";
            dispensarProducto();
        } else if (estadoActual.equals("EntregaProducto")) {
            System.out.println("Ya se está entregando un producto.");
        }
    }

    public void dispensarProducto() {
        if (estadoActual.equals("EntregaProducto")) {
            System.out.println("Dispensando bebida...");
            int cambio = saldo - PRECIO_BEBIDA;
            if (cambio > 0) {
                System.out.println("Devolviendo cambio: " + cambio);
            }
            saldo = 0;
            estadoActual = "EsperandoMoneda";
        } else {
            System.out.println("Por favor, seleccione una bebida primero.");
        }
    }

// Ejemplo de uso
    public static void main(String[] args) {
        MaquinaExpendedora maquina = new MaquinaExpendedora();

        maquina.insertarMoneda(50);  // Estado: EsperandoMoneda
        maquina.seleccionarBebida("Coca-Cola"); // No hay suficiente saldo

        maquina.insertarMoneda(50);  // Estado: CreditoSuficiente
        maquina.seleccionarBebida("Coca-Cola"); // Selecciona y pasa a entrega

        maquina.dispensarProducto();  // Estado: EntregaProducto y vuelta a EsperandoMoneda
    }
}
