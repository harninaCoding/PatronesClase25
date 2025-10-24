package telescope01;

import javax.annotation.processing.Generated;

public class Socio {
	// atributos sin posible valor por defecto obligatorios
	private String nombre;
	private int edad;
	private String ciudad;
	// atributos con valor por defecto
	private String plazaAparcamiento;
	private String numeroDespacho;
	
	@Generated("SparkTools")
	private Socio(Builder builder) {
		this.nombre = builder.nombre;
		this.edad = builder.edad;
		this.ciudad = builder.ciudad;
		this.plazaAparcamiento = builder.plazaAparcamiento;
		this.numeroDespacho = builder.numeroDespacho;
	}
	
	@Generated("SparkTools")
	public static Builder builder() {
		return new Builder();
	}
	
	@Generated("SparkTools")
	public static final class Builder {
		private String nombre;
		private int edad;
		private String ciudad;
		private String plazaAparcamiento;
		private String numeroDespacho;

		private Builder() {
		}

		public Builder withNombre(String nombre) {
			this.nombre = nombre;
			return this;
		}

		public Builder withEdad(int edad) {
			this.edad = edad;
			return this;
		}

		public Builder withCiudad(String ciudad) {
			this.ciudad = ciudad;
			return this;
		}

		public Builder withPlazaAparcamiento(String plazaAparcamiento) {
			this.plazaAparcamiento = plazaAparcamiento;
			return this;
		}

		public Builder withNumeroDespacho(String numeroDespacho) {
			this.numeroDespacho = numeroDespacho;
			return this;
		}

		public Socio build() {
			return new Socio(this);
		}
	}
	
}
