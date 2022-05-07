package lectures.lecture_1;

import static lectures.lecture_1.Para.copy;

public class Main {
    public static void main(String[] args) {
        class Data {
            String data;
            public Data(String data) {
                this.data = data;
            }
            @Override
            public String toString() {
                return "Data{" +
                        "data='" + data + '\'' +
                        '}';
            }
        }
//        Para<String, String> p1 = new Para<> ("Jan", "Kowalski");
//        System.out.println(p1);
//        Para<String, Data> p2 = new Para<> ("Jan Kowalski", new Data("2005-01-01"));
//        System.out.println(p2);
//        Para<String, Integer> p3 = new Para<>("Ala",2);
//        System.out.println(p3);


        Employee emp1 = new Employee("test1"),
                emp2 = new Employee("test2");
        Manager man1 = new Manager("sfa"),
                man2 = new Manager("mafsafsan2");
        Para<Employee, Employee> epar = new Para<>(emp1, emp2);
        Para<Manager, Manager> mpar = new Para<>(man1, man2);
        copy(mpar, epar);
        System.out.println(mpar);
    }

}
