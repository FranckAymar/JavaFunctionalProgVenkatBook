package playground.exception.functional;

public record Success<T>(T result) implements Try<T> {

    @Override
    public T getResult() {
        return result;
    }

    @Override
    public Throwable getError() {
        throw new IllegalStateException();
    }
}
