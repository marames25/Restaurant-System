package restaurant.ordering;

public class Delivery extends Order {
    @Override
    public double getTax() { return 0; }
}
