package restaurant.items.decorator;

public class Cheese extends AddOnDecorator {
    public Cheese(double price) {
        super("ADD-CHS", "Cheese", price, "AddOn", "Cheese");
    }
}
