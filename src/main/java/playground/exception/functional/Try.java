package playground.exception.functional;

import java.util.concurrent.Callable;
import java.util.function.Function;

public sealed interface Try<T> permits Success, Failure {

    T getResult();
    Throwable getError();

    static <T> Try<T> of(Callable<T> code){
        try {
            return new Success<>(code.call());
        }catch (Throwable throwable){
            return new Failure<>(throwable);
        }

    }

    default <R> Try<R> map(Function<T, R> mapper){
        if(this instanceof Success<?>){
            T result = getResult();
            return new Success<>(mapper.apply(result));
           //or  return of(() -> mapper.apply(result));
        }else{
            return new Failure<>(getError());
        }
    }
}

