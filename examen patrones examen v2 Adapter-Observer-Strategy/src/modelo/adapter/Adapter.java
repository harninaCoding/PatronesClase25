package modelo.adapter;

public interface Adapter<T, S> {
	public S convert(T t) throws Exception;
}
