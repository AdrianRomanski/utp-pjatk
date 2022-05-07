package lectures.lecture_1;

public class Para<S, T> {

    private S first;
    private T last;

    public Para(S first, T last) {
        this.first = first;
        this.last = last;
    }

    public Para() {
    }

    public S getFirst() {
        return first;
    }

    public void setFirst(S first) {
        this.first = first;
    }

    public T getLast() {
        return last;
    }

    public void setLast(T last) {
        this.last = last;
    }

    @Override
    public String toString() {
        return "Para{" +
                "first=" + first +
                ", last=" + last +
                '}';
    }

    static Para<? super Manager, ? super Manager> copy(Para<? extends Employee, ? extends Employee> src,
                                                       Para<? super Manager, ? super Manager> dest) {
        dest.setFirst((Manager) src.getFirst());
        dest.setLast((Manager) src.getLast());
        return dest;
    }
}

class Person {
    String name;
    public Person(String n) { name = n; } public String toString() {
        return "Person [name=" + name + "]"; }
}
class Employee extends Person { Employee(String n) { super(n); } public String toString() {
    return "Employee [name=" + name + "]"; }
}
class Manager extends Employee { Manager(String n) { super(n); } public String toString() {
    return "Manager [name=" + name + "]"; }
}
