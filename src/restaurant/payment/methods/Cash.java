package restaurant.payment.methods;

public class Cash implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Received cash payment: " + amount);

    }
    @Override
    public String getName() {
        return "Cash";
    }
}
