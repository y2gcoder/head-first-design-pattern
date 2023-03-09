package chapters.combining.decorator;

public class RubberDuck implements Quackable {
    @Override
    public void quack() {
        System.out.println("삑삑");
    }
}
