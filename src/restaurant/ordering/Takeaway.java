package restaurant.ordering;

public class Takeaway extends Order {
    @Override
    public double getTax() { return 0; }
}
