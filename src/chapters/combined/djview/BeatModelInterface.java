package chapters.combined.djview;

public interface BeatModelInterface {
    void initialize();
    void on();
    void off();
    void setBpm(int bpm);

    int getBpm();
    void registerObserver(BeatObserver observer);
    void removeObserver(BeatObserver observer);
    void registerObserver(BpmObserver observer);
    void removeObserver(BpmObserver observer);


}
