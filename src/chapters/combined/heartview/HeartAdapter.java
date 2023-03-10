package chapters.combined.heartview;

import chapters.combined.djview.BeatModelInterface;
import chapters.combined.djview.BeatObserver;
import chapters.combined.djview.BpmObserver;

public class HeartAdapter implements BeatModelInterface {
    HeartModelInterface heart;

    public HeartAdapter(HeartModelInterface heart) {
        this.heart = heart;
    }

    @Override
    public void initialize() {}

    @Override
    public void on() {}

    @Override
    public void off() {}

    @Override
    public int getBpm() {
        return heart.getHeartRate();
    }

    @Override
    public void setBpm(int bpm) {}

    @Override
    public void registerObserver(BeatObserver observer) {
        heart.registerObserver(observer);
    }

    @Override
    public void removeObserver(BeatObserver observer) {
        heart.registerObserver(observer);
    }

    @Override
    public void registerObserver(BpmObserver observer) {
        heart.registerObserver(observer);
    }

    @Override
    public void removeObserver(BpmObserver observer) {
        heart.removeObserver(observer);
    }
}
