package restaurant.discount;

public class BurgerDiscount implements Discount {
    public double apply(double price) {
        return price * 0.85; // 15% off
    }
}
