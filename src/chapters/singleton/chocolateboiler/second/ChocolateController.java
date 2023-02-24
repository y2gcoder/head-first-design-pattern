package chapters.singleton.chocolateboiler.second;

public class ChocolateController {
    public static void main(String[] args) {
        ChocolateBoiler boiler = ChocolateBoiler.UNIQUE_INSTANCE;
        boiler.fill();
        boiler.boil();
        boiler.drain();

        //will return the existing instance;
        ChocolateBoiler boiler2 = ChocolateBoiler.UNIQUE_INSTANCE;
    }
}
