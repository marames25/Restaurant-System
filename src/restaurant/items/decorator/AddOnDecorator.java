package restaurant.items.decorator;

import restaurant.items.FoodItem;

public abstract class AddOnDecorator extends FoodItem {

    protected FoodItem foodItem;

    public AddOnDecorator(String id, String description, double price, String menuType, String category) {
        super(id, description, price, menuType, category);
    }

    public void setFoodItem(FoodItem foodItem) {
        this.foodItem = foodItem;
    }

    @Override
    public String getId() {
        if (foodItem == null) return this.id;

        return foodItem.getId();
    }

    @Override
    public String getDescription() {
        if (foodItem == null) return this.description;

        return foodItem.getDescription().concat(" ").concat(this.description);
    }   

    @Override
    public double getPrice() {
        if (foodItem == null) return this.price;
        
        return foodItem.getPrice() + this.price;
    }
    
    @Override
    public String getCategory() {
        if (foodItem == null) return this.category;
        
        return foodItem.getCategory();
    }
    
    @Override
    public String getMenuType() {
        if (foodItem == null) return this.menuType;

        return foodItem.getMenuType();
    }
}
