package telescope01;

public class Persona {
	//obligatorios
	private int id;
	private String nombre;
	private String appellidos;
	// optionals
	private String phone;
	private String color;
	
	private Persona(Builder builder) {
		super();
		this.id=builder.id;
		this.nombre=builder.nombre;
		this.appellidos=builder.appellidos;
		this.phone=builder.phone;
		this.color=builder.color;
	}
	
	public static class Builder{
		private int id;
		private String nombre;
		private String appellidos;
		// optionals
		private String phone="00";
		private String color="white";
		
		public Builder(int id, String nombre, String appellidos) {
			super();
			this.id = id;
			this.nombre = nombre;
			this.appellidos = appellidos;
		}
		
		public Builder phone(String phone) {
			this.phone=phone;
			return this;
		}
		
		public Builder color(String color) {
			this.color=color;
			return this;
		}	
		public Persona build() {
			return new Persona(this);
		}
	}
	
	//
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getAppellidos() {
		return appellidos;
	}
	public void setAppellidos(String appellidos) {
		this.appellidos = appellidos;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
}
