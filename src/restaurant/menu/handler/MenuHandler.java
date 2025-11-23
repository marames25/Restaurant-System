package restaurant.menu.handler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import restaurant.items.FoodItem;
import restaurant.items.factory.ItemsFactory;
import restaurant.menu.component.*;;

public class MenuHandler {

    private Menu mainMenu;

    public MenuHandler() {
        // initializing every menu type
        this.mainMenu = new Menu("Main");
        MenuComponent non = new NonVegetarianMenu();
        MenuComponent veg = new VegetarianMenu();
        MenuComponent kids = new KidsMenu();
        MenuComponent add = new AddonMenu();

        // a map to make the choosing between instances easier and to follow ocp
        Map <String, MenuComponent> menus = new HashMap<>();
        
        menus.put("Non-Vegetarian", non);
        menus.put("Vegetarian", veg);
        menus.put("Kids", kids);
        menus.put("AddOn", add);

        ItemsFactory factory = ItemsFactory.getInstance();

        List <FoodItem> allItems = factory.getAllItems();

        // assigning each item to its corresponding menu type
        for (FoodItem item : allItems) {
            MenuComponent tmp = new LeafItem(item);
            menus.get(item.getMenuType()).addComponent(tmp);
        }

        // adding the submenus to the main menu
        for (var item : menus.values()) {
            mainMenu.addComponent(item);
        }
    }
    
    public String[][] takeUserOrders(Scanner scanner) {
        mainMenu.display();

         System.out.println("\nPlease enter your orders.");
         System.out.println("Format: MAIN_ITEM ADDON1 ADDON2 ...");
         System.out.println("Type 'DONE' to finish.\n");
         
         List<String[]> ordersList = new ArrayList<>();
         
         while (true) {
             System.out.print("Order > ");
             String line = scanner.nextLine().trim();
        
             if (line.equalsIgnoreCase("DONE")) break;
             if (line.isEmpty()) continue;
        
             // split items by space
             String[] entry = line.split("\\s+");
        
             // must have at least 1 item (the main item)
             if (entry.length == 0) continue;
        
             ordersList.add(entry);
         }
     
         // converting list → 2D array
         String[][] result = new String[ordersList.size()][];
         for (int i = 0; i < ordersList.size(); i++) {
             result[i] = ordersList.get(i);
         }
    
        return result;
    }

}
