package tienda01;

//Clase Producto que utiliza la estrategia de descuento
class Producto {
	private String nombre;
	private double precio;
	private DescuentoStrategy descuentoStrategy;

	public Producto(String nombre, double precio) {
		this.nombre = nombre;
		this.precio = precio;
	}

	public void cambiarNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setDescuentoStrategy(DescuentoStrategy descuentoStrategy) {
		this.descuentoStrategy = descuentoStrategy;
	}

	public double calcularPrecioFinal() {
		if (descuentoStrategy == null) {
			return precio;
		}
		return descuentoStrategy.aplicarDescuento(precio);
	}
}