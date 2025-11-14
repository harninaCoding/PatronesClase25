package ejemplo02Solucion.bientotalmente;

import java.util.Optional;

public interface Repo<T,K> {
	public Optional<T> buscar(K k);
	public void grabar(T t);
	public void borrar(K k);
}
