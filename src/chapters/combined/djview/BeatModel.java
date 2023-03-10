package chapters.combined.djview;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.Line;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class BeatModel implements BeatModelInterface, Runnable {
    List<BeatObserver> beatObservers = new ArrayList<>();
    List<BpmObserver> bpmObservers = new ArrayList<>();
    int bpm = 90;
    Thread thread;
    boolean stop = false;
    Clip clip;

    @Override
    public void initialize() {
        try {
            File resource = new File("clap.wav");
            clip = (Clip) AudioSystem.getLine(new Line.Info(Clip.class));
            clip.open(AudioSystem.getAudioInputStream(resource));
        } catch (Exception e) {
            System.out.println("Error: Can't load clip");
            System.out.println(e);
        }
    }

    @Override
    public void on() {
        bpm = 90;
//        notifyBpmObservers();
        thread = new Thread(this);
        stop = false;
        thread.start();
    }

    @Override
    public void off() {
        stopBeat();
        stop = true;
    }

    @Override
    public void run() {
        while (!stop) {
            playBeat();
            notifyBeatObservers();
            try {
                Thread.sleep(60000 / getBpm());
            } catch (Exception e) {}
        }
    }

    @Override
    public void setBpm(int bpm) {
        this.bpm = bpm;
        notifyBpmObservers();
    }

    @Override
    public int getBpm() {
        return bpm;
    }

    @Override
    public void registerObserver(BeatObserver observer) {
        beatObservers.add(observer);
    }

    public void notifyBeatObservers() {
        for (BeatObserver observer : beatObservers) {
            observer.updateBeat();
        }
    }

    @Override
    public void registerObserver(BpmObserver observer) {
        bpmObservers.add(observer);
    }

    public void notifyBpmObservers() {
        for (BpmObserver observer : bpmObservers) {
            observer.updateBpm();
        }
    }

    @Override
    public void removeObserver(BeatObserver observer) {
        int i = beatObservers.indexOf(observer);
        if (i >= 0) {
            beatObservers.remove(i);
        }
    }

    @Override
    public void removeObserver(BpmObserver observer) {
        int i = bpmObservers.indexOf(observer);
        if (i >= 0) {
            bpmObservers.remove(i);
        }
    }

    public void playBeat() {
        clip.setFramePosition(0);
        clip.start();
    }

    public void stopBeat() {
        clip.setFramePosition(0);
        clip.stop();
    }
}
