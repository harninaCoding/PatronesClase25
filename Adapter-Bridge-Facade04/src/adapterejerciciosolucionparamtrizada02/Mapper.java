package adapterejerciciosolucionparamtrizada02;

@FunctionalInterface
public interface Mapper<T,S> {
	public S map(T t);
}
