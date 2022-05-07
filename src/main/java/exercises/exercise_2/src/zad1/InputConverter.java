package exercises.exercise_2.src.zad1;

import java.util.function.Function;

public class InputConverter<T> {
    private final T value;

    public InputConverter(T t) {
        this.value = t;
    }

    public <U> U convertBy(Function... functions) {
        Object actual = this.value;
        Object result = null;

        for (Function f : functions) {
            result = f.apply(actual);
            actual = result;
        }

        return (U) result;
    }
}
