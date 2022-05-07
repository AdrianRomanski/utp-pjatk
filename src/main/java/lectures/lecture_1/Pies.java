package lectures.lecture_1;

public class Pies extends Zwierz implements Speakable, Moveable {
    public Pies() {}
    public Pies(String s) {
        super(s);
    }
    public String getTyp() {
        return "Pies";
    }
    public String getVoice(int voice) {
        if (voice == LOUD) {
            return "HAU... HAU... HAU... ";
        } else {
            return "Hau... Hau..."; }
        }
    public Pies start() {
        System.out.println("Pies " + getName() + " biegnie");
        return this;
    }
    public Pies stop() {
        System.out.println("Pies " + getName() + " stan��");
        return this;
    }
    public Pies merda() { System.out.println("Merda ogonem");
        return this;
    }
}
