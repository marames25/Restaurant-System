package restaurant.ordering;

public class DineIn extends Order {
    private final double taxRate = 0.12;

    @Override
    public double getTax() {
        return getTotalPrice() * taxRate;
    }
}
