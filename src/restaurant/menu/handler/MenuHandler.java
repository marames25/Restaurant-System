package restaurant.menu.handler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import restaurant.items.FoodItem;
import restaurant.items.factory.ItemsFactory;
import restaurant.menu.component.*;;

public class MenuHandler {

    private Menu mainMenu;

    public MenuHandler() {
        this.mainMenu = new Menu("Main");
        MenuComponent non = new NonVegetarianMenu();
        MenuComponent veg = new VegetarianMenu();
        MenuComponent kids = new KidsMenu();
        MenuComponent add = new AddonMenu();

        Map <String, MenuComponent> menus = new HashMap<>();
        
        menus.put("Non-Vegetarian", non);
        menus.put("Vegetarian", veg);
        menus.put("Kids", kids);
        menus.put("AddOn", add);

        ItemsFactory factory = ItemsFactory.getInstance();

        List <FoodItem> allItems = factory.getAllItems();
        for (FoodItem item : allItems) {
            MenuComponent tmp = new LeafItem(item);
            menus.get(item.getMenuType()).addComponent(tmp);
        }

        for (var item : menus.values()) {
            mainMenu.addComponent(item);
        }
    }

    public String display() {
        mainMenu.display();
        
        return null;
    }
}
