package ejemplo02Solucion.casibien;


public interface Repo<T,S> {

	public void grabar(T t);
	public void borrar(S s);
}
