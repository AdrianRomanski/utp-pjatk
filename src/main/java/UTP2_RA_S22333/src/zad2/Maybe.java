package UTP2_RA_S22333.src.zad2;

import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Maybe <T> {
    T value;
    public Maybe(){}
    public Maybe(T value){this.value = value;}

    public static<T> Maybe<T> of(T value){
        return new Maybe<>(value);
    }

    public void ifPresent(Consumer<T> cons){
        if(isNotNull()) cons.accept(value);
    }

    public boolean isNotNull(){
        return value != null;
    }

    public <R> Maybe<R> map(Function<T,R> func) {
        return isNotNull() ? new Maybe<>(func.apply(value)) : new Maybe<>();
    }

    public T get() throws NoSuchElementException {
        if(!isNotNull()) throw new NoSuchElementException("maybe is empty");
        return value;
    }

    public T orElse(T defVal) {
        return isNotNull() ? value : defVal;
    }

    public Maybe<T> filter(Predicate<T> pred) {
       return isNotNull() && pred.test(value) ? this : new Maybe<>();
    }

    @Override
    public String toString() {
        return isNotNull() ? "Maybe has a value " + value : "Maybe is empty";
    }
}
