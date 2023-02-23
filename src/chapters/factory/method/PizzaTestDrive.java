package chapters.factory.method;

public class PizzaTestDrive {
    public static void main(String[] args) {
        NYPizzaStore nyPizzaStore = new NYPizzaStore();
        ChicagoPizzaStore chicagoPizzaStore = new ChicagoPizzaStore();

        Pizza pizza = nyPizzaStore.orderPizza("cheese");
        System.out.println("에단이 주문한 "+pizza.getName()+"\n");

        pizza = chicagoPizzaStore.orderPizza("cheese");
        System.out.println("조엘이 주문한 "+pizza.getName()+"\n");
    }
}
