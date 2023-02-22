package chapters.decorator.starbuzz.before;

public class Beverage {
    private static final double MILK_COST = 2;
    private static final double SOY_COST = 1.5;
    private static final double MOCHA_COST = 2.1;
    private static final double WHIP_COST = 1.8;

    private boolean hasMilk() {
        return true;
    }

    private boolean hasSoy() {
        return false;
    }

    private boolean hasMocha() {
        return true;
    }

    private boolean hasWhip() {
        return false;
    }

    public double cost() {
        double condimentCost = 0.0;
        if (hasMilk()) {
            condimentCost += MILK_COST;
        }
        if (hasSoy()) {
            condimentCost += SOY_COST;
        }
        if (hasMocha()) {
            condimentCost += MOCHA_COST;
        }
        if (hasWhip()) {
            condimentCost += WHIP_COST;
        }
        return condimentCost;
    }
}
