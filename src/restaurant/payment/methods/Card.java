package restaurant.payment.methods;

public class Card implements PaymentMethod {
    private String cardNumber;
    public Card(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Charging card " + cardNumber +"Paying " + amount );
    }
    @Override
    public String getName() {
        return "Card";
    }
}
