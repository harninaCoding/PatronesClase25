package teoriabienparametrizada04;

public class ConcreteProductB extends Product {
	//A parte de la implementacion de metodos comunes
	//Podemos a�adir propiedes y metodos concretos

	public int mio=3;
	@Override
	public void operacion() {
		// TODO Auto-generated method stub
		System.out.println("operacion del producto 2 "+this.getClass().getName());
	}
//	public int getPcss(){
//		return pcss;
//	}
	public void croquetaVoladora(){
		System.out.println("yo no soy de esas");
	}
}
