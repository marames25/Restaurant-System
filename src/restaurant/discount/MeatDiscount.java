package restaurant.discount;

public class MeatDiscount implements Discount {
    public double apply(double price) {
        return price * 0.95; // 5% off
    }
}
