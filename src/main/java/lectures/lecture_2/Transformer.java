package lectures.lecture_2;

public interface Transformer<T,S> {
    T transform(S v);
}
