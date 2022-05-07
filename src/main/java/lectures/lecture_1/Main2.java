package lectures.lecture_1;

public class Main2 {
    public static void main(String[] args) {
        Integer[] arr1 = { 1, 2 , 7, -3 };
        Integer[] arr2 = { 1, 7 , 8, -10 };
        String[] napisy = { "A", "Z", "C" };
        GenArr<Integer> gai = new GenArr<>(arr1);
        System.out.println(gai.max() + " " + gai.min());
        gai.init(arr2);
        System.out.println(gai.max() + " " + gai.min());
        GenArr<String> gas = new GenArr<>(napisy);
        System.out.println(gas.max() + " " + gas.min());
    }
}
