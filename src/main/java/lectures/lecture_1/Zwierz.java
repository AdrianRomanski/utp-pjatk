package lectures.lecture_1;

public abstract class Zwierz {
    private String name = "bez imienia";
    public Zwierz() {}
    public Zwierz(String s) {
        name = s;
    }
    public abstract String getTyp();
    public String getName() {
        return name;
    }
}
