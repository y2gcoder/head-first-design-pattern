package chapters.combined.heartview;

import chapters.combined.djview.BeatObserver;
import chapters.combined.djview.BpmObserver;

public interface HeartModelInterface {
    int getHeartRate();
    void registerObserver(BeatObserver observer);
    void removeObserver(BeatObserver observer);

    void registerObserver(BpmObserver observer);
    void removeObserver(BpmObserver observer);
}
