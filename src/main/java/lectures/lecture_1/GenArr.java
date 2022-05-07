package lectures.lecture_1;

public class GenArr<T extends Comparable<T>> {
    private T[] arr;
    private Para<T, T> minMax;

    public GenArr(T[] a) {
        init(a);
    }

    public void init(T[] a) {
        if (a == null || a.length == 0) {
            throw new IllegalArgumentException("Invalid array init");
        }
        minMax = null;
        arr = a;
    }

    public T max() {
        return evaluate("MAX").getFirst();
    }

    public T min() {
        return evaluate("MIN").getLast();
    }

    private Para<T, T> evaluate(String kind) {
        if (minMax == null) {
            minMax = new Para<>();
        }
        T v = arr[0];
        switch (kind) {
            case "MAX": {
                if (minMax.getFirst() == null) {
                    for (T e : arr) {
                        if (e.compareTo(v) > 0) {
                            v = e;
                        }
                    }
                    minMax.setFirst(v);
                }
            }
            case "MIN": {
                if (minMax.getLast() == null) {
                    for (T e : arr) {
                        if (e.compareTo(v) < 0) {
                            v = e;
                        }
                    }
                    minMax.setLast(v);
                }
            }
        }
        return minMax;
    }
}
