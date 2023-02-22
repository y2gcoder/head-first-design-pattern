package chapters.decorator.starbuzz.after;

public class Soy extends CondimentDecorator {
    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getDescription() {
        return beverage.getDescription() + ", 두유";
    }

    @Override
    public double cost() {
        double cost = beverage.cost();
        Size beverageSize = beverage.getSize();
        if (beverageSize == Size.TALL) {
            cost += .10;
        } else if (beverageSize == Size.GRANDE) {
            cost += .15;
        } else if (beverageSize == Size.VENTI) {
            cost += .20;
        }
        return cost;
    }
}
