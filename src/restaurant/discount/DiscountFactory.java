package restaurant.discount;

public class DiscountFactory {

    public Discount getDiscount(String category) {
        if (category == null || category.isEmpty())
            return null;

        category = category.toLowerCase();

        if (category.contains("Pizza"))
            return new PizzaDiscount();

        if (category.contains("Burger"))
            return new BurgerDiscount();

        if (category.contains("Meal"))
            return new MeatDiscount();

        
        return null;
    }
}
