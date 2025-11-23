package restaurant.items;

public class Drink extends FoodItem {

    public Drink(String id, String description, double price, String menuType) {
        super(id, description, price, menuType, "Drink");
    }
}
