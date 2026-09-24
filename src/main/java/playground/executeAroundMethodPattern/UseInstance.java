package playground.executeAroundMethodPattern;

@FunctionalInterface
public interface UseInstance<I, E extends Throwable> {
    void accept(I instance) throws E;
}
