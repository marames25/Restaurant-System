package restaurant.items.decorator;

public class Salad extends AddOnDecorator {
    public Salad(double price) {
        super("ADD-SLD", "Salad", price, "AddOn", "Salad");
    }
}
