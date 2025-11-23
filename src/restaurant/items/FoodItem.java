package restaurant.items;

public abstract class FoodItem {

    protected String id;
    protected String description;
    protected double price;
    protected String category;
    protected String menuType;

    public FoodItem(String id, String description, double price, String menuType, String category) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.menuType = menuType;
        this.category = category;
    }
    public String getId() { return id; }

    public String getDescription() { return description; }

    public double getPrice() { return price; }

    public String getCategory() { return category; }

    public String getMenuType() {return menuType;}
}
