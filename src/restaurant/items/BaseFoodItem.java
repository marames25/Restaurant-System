package restaurant.items;

public abstract class BaseFoodItem implements FoodItem {

    protected String id;
    protected String description;
    protected double price;
    protected String category;

    @Override
    public String getId() { return id; }

    @Override
    public String getDescription() { return description; }

    @Override
    public double getPrice() { return price; }

    @Override
    public String getCategory() { return category; }
}
