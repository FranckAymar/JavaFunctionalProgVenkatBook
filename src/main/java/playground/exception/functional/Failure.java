package playground.exception.functional;

public record Failure<T>(Throwable throwable) implements Try<T> {

    @Override
    public T getResult() {
        throw new IllegalStateException();
    }

    @Override
    public Throwable getError() {
        return throwable;
    }
}
