package restaurant.payment.methods;

public class MobileWallet implements PaymentMethod {

    private String walletID;

    public MobileWallet(String walletID) {
        this.walletID = walletID;

    }

    @Override
    public void pay(double amount) {
        System.out.println("Paying " + amount + " for mobile wallet");
    }

    @Override
    public String getName() {
        return "Mobile Wallet";
    }
}
