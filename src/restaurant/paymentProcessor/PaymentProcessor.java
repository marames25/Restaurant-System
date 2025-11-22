package restaurant.payment;

import restaurant.payment.methods.PaymentMethod;
import restaurant.discount.Discount;
import restaurant.ordering.Order;

public class PaymentProcessor {

    private PaymentMethod paymentMethod;
    private Discount discount; // may be null => no discount
    private Order order;

    public PaymentProcessor(PaymentMethod paymentMethod, Discount discount, Order order) {
        this.paymentMethod = paymentMethod;
        this.discount = discount;
        this.order = order;
    }

    public void checkout() {
        double subtotal = order.getTotalPrice();
        double discounted = Optional.ofNullable(discount).map(d -> d.apply(subtotal)).orElse(subtotal);
        double total = discounted + order.getTax();
        paymentMethod.pay(total);
    }

    // setters/getters
    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
}
