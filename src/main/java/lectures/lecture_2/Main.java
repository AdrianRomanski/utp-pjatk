package lectures.lecture_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {

    static <T, S> List<T> create(List<S> src, Filter<S> f, Transformer<T, S> t) {
        List<T> target = new ArrayList<>();
        for (S e : src) {
            if (f.test(e)) {
                target.add(t.transform(e));
            }
        }
        return target;
    }

    static <S> void change(List<S> list, Filter<S> f, Modifier<S> mod) {
        for (S e : list) {
            if (f.test(e)) {
                mod.modify(e);
            }
        }
    }

    static <T, S> List<T> create2(List<S> src,  Predicate<S> filter, Function<S, T> func) {
        List<T> target = new ArrayList<>();
        for (S e : src) {
            if (filter.test(e)) { target.add(func.apply(e));
            } }
        return target;
    }

    static <S> void change(List<S> list, Filter<S> f, Consumer<S> mod) {
        for (S e : list) {
            if (f.test(e)) {
                mod.accept(e);
            }
        }
    }

    public static void main(String[] args) {
        List<Integer> num = Arrays.asList( 1, 3, 5, 10, 9, 12, 7);
        List<String> txt = Arrays.asList("ala", "ma", "kota",
                "aleksandra", "psa", "azora" );
        List<Employee> emp = Arrays.asList(
                new Employee("Kowal", "Jan", 34, 3400.0),
                new Employee("As", "Ala", 27, 4100.0),
                new Employee("Kot", "Zofia", 33, 3700.0),
                new Employee("Puchacz", "Jan", 41 , 3600.0) );
        System.out.println(
                create(num, n-> n%2!=0, n->n*100)
        );
        System.out.println( create(txt,
                s -> s.startsWith("a"),
                s -> s.toUpperCase() + " " + s.length())
        );
        List<Employee> doPodwyzki =
                create(emp,
                        e -> e.getAge() > 30 && e.getSalary() < 4000,
                        e -> e );
        System.out.println("Podwyzki powinni uzyskac:");
        System.out.println(doPodwyzki);

        List<Double> sal = create(emp,
                e -> true,
                Employee::getSalary
        );
        System.out.println(sal);


    }



}


