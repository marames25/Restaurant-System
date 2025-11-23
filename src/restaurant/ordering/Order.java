package restaurant.ordering;

import restaurant.items.FoodItem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Order {

    protected List<FoodItem> items = new ArrayList<>();
    protected double tax;

    public Order(double tax) {this.tax = tax;}

    public void addItem(FoodItem item) {
        if (item != null) items.add(item);
    }

    public void removeItem(FoodItem item) {
        items.remove(item);
    }

    public List<FoodItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public int getItemsCount() {
        return items.size();
    }

    public double getTax() {
        return this.tax;
    }
}
