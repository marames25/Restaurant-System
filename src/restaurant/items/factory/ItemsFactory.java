package restaurant.items.factory;
import restaurant.items.*;
import restaurant.items.decorator.BBQSauce;
import restaurant.items.decorator.Cheese;
import restaurant.items.decorator.Salad;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemsFactory {

    private Map<String, FoodItem> inventory;
    private static ItemsFactory instance;

    private ItemsFactory() {
        inventory = new HashMap<>();

       // ---------------- PIZZAS ----------------
        inventory.put("PZ-1-n", new Pizza("PZ-1-n", "Chicken Ranch Pizza", 300.0, "Non-Vegetarian"));
        inventory.put("PZ-1-v", new Pizza("PZ-1-v", "Vegetables Pizza", 280.0, "Vegetarian"));
        inventory.put("PZ-2-n", new Pizza("PZ-2-n", "Pepperoni Pizza", 320.0, "Non-Vegetarian"));
        inventory.put("PZ-3-n", new Pizza("PZ-3-n", "BBQ Chicken Pizza", 330.0, "Non-Vegetarian"));
        inventory.put("PZ-4-v", new Pizza("PZ-4-v", "Four Cheese Pizza", 350.0, "Vegetarian"));
        inventory.put("PZ-5-v", new Pizza("PZ-5-v", "Margherita Pizza", 260.0, "Vegetarian"));
        inventory.put("PZ-6-n", new Pizza("PZ-6-n", "Spicy Chicken Pizza", 310.0, "Non-Vegetarian"));
        inventory.put("PZ-7-v", new Pizza("PZ-7-v", "Mushroom Lovers Pizza", 290.0, "Vegetarian"));

        // ---------------- BURGERS ----------------
        inventory.put("BG-1-b", new Burger("BG-1-b", "Beef Burger", 180.0, "Non-Vegetarian"));
        inventory.put("BG-2-b", new Burger("BG-2-b", "Double Beef Burger", 250.0, "Non-Vegetarian"));
        inventory.put("BG-3-c", new Burger("BG-3-c", "Crispy Chicken Burger", 170.0, "Non-Vegetarian"));
        inventory.put("BG-4-c", new Burger("BG-4-c", "Grilled Chicken Burger", 190.0, "Non-Vegetarian"));
        inventory.put("BG-5-v", new Burger("BG-5-v", "Veggie Burger", 160.0, "Vegetarian"));
        inventory.put("BG-6-f", new Burger("BG-6-f", "Fish Fillet Burger", 200.0, "Non-Vegetarian"));

        // ---------------- MEALS ----------------
        inventory.put("ML-1-6", new Meal("ML-1-6", "6 Chicken Pieces with Fries", 400.0, "Non-Vegetarian"));
        inventory.put("ML-2-1", new Meal("ML-2-1", "1 Chicken Piece + Fries + Toy", 150.0, "Kids"));
        inventory.put("ML-3-9", new Meal("ML-3-9", "9 Chicken Pieces Family Meal", 650.0, "Non-Vegetarian"));
        inventory.put("ML-4-3", new Meal("ML-4-3", "3 Chicken Strips Meal", 230.0, "Non-Vegetarian"));
        inventory.put("ML-5-2", new Meal("ML-5-2", "2 Chicken Pieces + Rice", 210.0, "Non-Vegetarian"));
        inventory.put("ML-6-v", new Meal("ML-6-v", "Vegetarian Combo Meal", 180.0, "Vegetarian"));
        inventory.put("ML-7-b", new Meal("ML-7-b", "Beef Bowl Meal", 260.0, "Non-Vegetarian"));

        // ---------------- KIDS ITEMS ----------------
        inventory.put("KD-1-b", new Meal("KD-1-b", "Kids Beef Slider Meal", 120.0, "Kids"));
        inventory.put("KD-2-c", new Meal("KD-2-c", "Kids Chicken Nuggets Meal", 110.0, "Kids"));
        inventory.put("KD-3-p", new Meal("KD-3-p", "Kids Small Pizza", 140.0, "Kids"));
    
        inventory.put("ADD-CHS", new Cheese(15));
        inventory.put("ADD-BBQ", new BBQSauce(10));
        inventory.put("ADD-SLD", new Salad(14));

    }

    public static ItemsFactory getInstance() {
        if (instance == null) 
            instance = new ItemsFactory();
        
        return instance;
    }
    
    public FoodItem getItem(String id) {
        return inventory.get(id);
    }

    public List<FoodItem> getAllItems() {
    return new ArrayList<>(inventory.values());
}
}
