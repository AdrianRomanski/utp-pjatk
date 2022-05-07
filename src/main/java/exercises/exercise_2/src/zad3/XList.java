package exercises.exercise_2.src.zad3;

import java.util.*;
import java.util.function.Function;

public class XList<T> extends ArrayList<T> {
    public XList(Collection<T> collection) {
        super(collection);
    }
    public XList(T... elements) {
        Collections.addAll(this, elements);
    }

    public static <U> XList<U> of (U... elements) {
        return new XList<>(elements);
    }

    public static <U> XList<U> of (Collection<U> collection) {
        return new XList<>(collection);
    }

    public static XList<String> tokensOf(String s, String regex) {
        return XList.of(s.split(regex));
    }

    public static XList<String> tokensOf(String s) {
        return XList.tokensOf(s, "\\s");
    }

    public static XList<String> charsOf(String s) {
        return XList.tokensOf(s, "");
    }

    public XList<T> clone() {
        return XList.of(this);
    }

    public XList<T> union(Collection<T> collection) {
        XList<T> cpy = this.clone();
        cpy.addAll(collection);

        return cpy;
    }

    public XList<T> union(T... elements) {
        return this.union(XList.of(elements));
    }

    public XList<T> diff(Collection<T> collection) {
        XList<T> newList = new XList<T>();
        for (T el: this) {
            if (!collection.contains(el)) {
                newList.add(el);
            }
        }
        return newList;
    }

    public XList<T> unique() {
        return XList.of(new LinkedHashSet<T>(this));
    }

    public <Z> XList<Z> collect(Function<T, Z> function) {
        XList<Z> newList = new XList<>();
        for(int i = 0; i < this.size(); i++) {
            newList.add(function.apply(this.get(i)));
        }
        return newList;
    }

}
