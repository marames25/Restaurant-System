package restaurant.ordering;

public class Takeaway extends Order {
    private final double taxRate = 0.02;
    @Override
    public double getTax() {
        return getTotalPrice() * taxRate;
    }
}
