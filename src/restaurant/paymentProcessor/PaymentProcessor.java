package restaurant.payment;

import restaurant.payment.methods.PaymentMethod;
import restaurant.discount.Discount;
import restaurant.ordering.Order;

public class PaymentProcessor {

    private PaymentMethod paymentMethod;
    private Discount discount;
    private Order order;

    public void checkout() { }
}
