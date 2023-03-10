package chapters.combined.heartview;

public class HeartTestDrive {
    public static void main(String[] args) {
        HeartModel heartModel = new HeartModel();
        HeartController controller = new HeartController(heartModel);
    }
}
