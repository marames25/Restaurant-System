package restaurant.discount;

public class PizzaDiscount implements Discount {
    @Override
    public double apply(double price) {
        return price * 0.90; // 10% off
    }
}
