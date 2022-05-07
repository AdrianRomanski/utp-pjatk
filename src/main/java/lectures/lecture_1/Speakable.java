package lectures.lecture_1;

public interface Speakable {
    int QUIET = 0;
    int LOUD = 1;
    String getVoice(int voice);
}
