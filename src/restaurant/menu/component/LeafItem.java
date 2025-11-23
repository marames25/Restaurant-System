package restaurant.menu.component;

import restaurant.items.FoodItem;

public class LeafItem extends MenuComponent {

    private FoodItem item;

    public LeafItem(FoodItem item) {
        if (item == null) {
            throw new IllegalArgumentException("FoodItem cannot be null for a LeafItem");
        }
        
        this.item = item;
    }

    @Override
    public void display() { 
        System.out.println(item.getId() + ") " + item.getDescription() + " : " +  item.getPrice() + "EGP");
    }

    @Override
    public void addComponent(MenuComponent component) throws IllegalStateException {
        throw new IllegalStateException("leaves cannot have nested components");
    }
    
    @Override
    public void removeComponent(MenuComponent component) throws IllegalStateException {
        throw new IllegalStateException("leaves cannot have nested components");
    }
}
