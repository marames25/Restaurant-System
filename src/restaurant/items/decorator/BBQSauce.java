package restaurant.items.decorator;

public class BBQSauce extends AddOnDecorator {
    public BBQSauce(double price) {
        super("ADD-BBQ", "BBQ Sauce", price, "AddOn", "Sauce");
    }
}
