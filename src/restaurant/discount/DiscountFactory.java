package restaurant.discount;

public class DiscountFactory {

    public Discount getDiscount(String category) {
        if (category == null || category.isEmpty())
            return null;

        category = category.toLowerCase();

        if (category.contains("pizza"))
            return new PizzaDiscount();

        if (category.contains("burger"))
            return new BurgerDiscount();

        if (category.contains("meal"))
            return new MeatDiscount();

        
        return null;
    }
}
