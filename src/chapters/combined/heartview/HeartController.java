package chapters.combined.heartview;

import chapters.combined.djview.ControllerInterface;
import chapters.combined.djview.DjView;

public class HeartController implements ControllerInterface {
    HeartModelInterface model;
    DjView view;

    public HeartController(HeartModelInterface model) {
        this.model = model;
        view = new DjView(this, new HeartAdapter(model));
        view.createView();
        view.createControls();
        view.disableStopMenuItem();
        view.disableStartMenuItem();
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void increaseBpm() {

    }

    @Override
    public void decreaseBpm() {

    }

    @Override
    public void setBpm(int bpm) {

    }
}
