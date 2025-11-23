package restaurant.payment.methods;

public class MobileWallet implements PaymentMethod {

    @Override
    public void pay(double amount) {
        System.out.println("Paying " + amount + " for mobile wallet");
    }

    @Override
    public String getName() {
        return "Mobile Wallet";
    }
}
