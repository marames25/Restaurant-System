package restaurant.payment.methods;

public class Card implements PaymentMethod {
   
    @Override
    public void pay(double amount) {
        System.out.println("Charging card Paying " + amount );
    }
    @Override
    public String getName() {
        return "Card";
    }
}
