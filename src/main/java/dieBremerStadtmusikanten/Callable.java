package dieBremerStadtmusikanten;

public interface Callable<V> {
    default V call() throws Exception{
        return call();
    }
}
