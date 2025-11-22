package restaurant.items.decorator;

import restaurant.items.FoodItem;

public abstract class AddOnDecorator implements FoodItem {

    protected FoodItem foodItem;

    public AddOnDecorator(FoodItem foodItem) {
        this.foodItem = foodItem;
    }
}
