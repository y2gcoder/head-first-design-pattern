package chapters.combined.heartview;

import chapters.combined.djview.BeatObserver;
import chapters.combined.djview.BpmObserver;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HeartModel implements HeartModelInterface, Runnable {

    List<BeatObserver> beatObservers = new ArrayList<>();
    List<BpmObserver> bpmObservers = new ArrayList<>();

    int time = 1000;
    int bpm = 90;
    Random random = new Random(System.currentTimeMillis());
    Thread thread;

    public HeartModel() {
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        int lastrate = -1;

        while(true) {
            int change = random.nextInt(10);
            if (random.nextInt(2) == 0) {
                change = 0 - change;
            }
            int rate = 60000 / (time + change);
            if (rate < 120 && rate > 50) {
                time += change;
                notifyBeatObservers();
                if (rate != lastrate) {
                    lastrate = rate;
                    notifyBpmObservers();
                }
            }
            try {
                Thread.sleep(time);
            } catch (Exception e) {}
        }
    }

    @Override
    public int getHeartRate() {
        return 60000/time;
    }

    @Override
    public void registerObserver(BeatObserver observer) {
        beatObservers.add(observer);
    }

    @Override
    public void removeObserver(BeatObserver observer) {
        beatObservers.remove(observer);
    }

    private void notifyBeatObservers() {
        for (BeatObserver observer : beatObservers) {
            observer.updateBeat();
        }
    }

    @Override
    public void registerObserver(BpmObserver observer) {
        bpmObservers.add(observer);
    }

    @Override
    public void removeObserver(BpmObserver observer) {
        bpmObservers.remove(observer);
    }

    public void notifyBpmObservers() {
        for (BpmObserver observer : bpmObservers) {
            observer.updateBpm();
        }
    }
}
