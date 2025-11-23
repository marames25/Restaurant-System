package restaurant.items;

public class Meal extends FoodItem { 

    public Meal(String id, String description, double price, String menuType) {
        super(id, description, price, menuType, "Meal");
    }
}
