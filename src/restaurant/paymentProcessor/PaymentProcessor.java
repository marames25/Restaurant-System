package restaurant.paymentProcessor;

import restaurant.payment.methods.PaymentMethod;
import restaurant.discount.DiscountFactory;
import restaurant.ordering.Order;
import restaurant.items.FoodItem;

public class PaymentProcessor {

    private PaymentMethod paymentMethod;
    private Order order;

    public PaymentProcessor(PaymentMethod paymentMethod, Order order) {
        this.paymentMethod = paymentMethod;
        this.order = order;
    }

    public void checkout() {
        double subtotal = 0;
        for (FoodItem item : order.getItems()) {
            double discountedPrice = DiscountFactory.applyDiscount(item);
            subtotal += discountedPrice;
        }
        double tax = order.getTax();
        double total = subtotal + tax;
        paymentMethod.pay(total);
    }

    // setters/getters
    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }


    public void setOrder(Order order) {
        this.order = order;
    }
}
