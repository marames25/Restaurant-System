package restaurant.ordering;

public class Delivery extends Order {
    private final double taxRate = 0.05;
    private final double deliveryFee;

    public Delivery(){
        this(10.0);
    }
    public Delivery( double deliveryFee) {
        this.deliveryFee = deliveryFee;
    }
    @Override
    public double getTax() {
        return (getTotalPrice() + deliveryFee) * taxRate;
    }
    public double getDeliveryFee() {
        return deliveryFee;
    }
}
