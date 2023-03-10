package chapters.combined.djview;

public class DjTestDrive {
    public static void main(String[] args) {
        BeatModelInterface model = new BeatModel();
        BeatController controller = new BeatController(model);
    }
}
