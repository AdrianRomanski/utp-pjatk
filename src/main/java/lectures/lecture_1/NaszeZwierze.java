package lectures.lecture_1;

import java.lang.reflect.Method;

public class NaszeZwierze<T extends Zwierz & Moveable & Speakable> {
    private T z;
    public NaszeZwierze(T zwierz) {
        z = zwierz;
    }
    public void speak() {
        System.out.println( z.getTyp()+" "+z.getName() +
                " mówi " + z.getVoice(Speakable.LOUD)
        );
    }
    T get() {
        return z;
    }
    public void startSpeakAndStop() {
        z.start();
        speak();
        z.stop();
    }
    public static void main(String[] args) {
        NaszeZwierze<Pies> p = new NaszeZwierze<>(new Pies("kuba"));
        for (Method m : p.getClass().getDeclaredMethods()) {
            System.out.println(m.getName());
        }
        p.startSpeakAndStop();
        p.get().merda();
    }
}
