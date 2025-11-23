package restaurant.paymentProcessor;

import restaurant.payment.methods.PaymentMethod;
import restaurant.discount.Discount;
import restaurant.discount.DiscountFactory;
import restaurant.ordering.Order;
import restaurant.items.FoodItem;

public class PaymentProcessor {

    private PaymentMethod paymentMethod;
    private Order order;
    private DiscountFactory dFactory;
    double total, tax;

    public PaymentProcessor(PaymentMethod paymentMethod, Order order) {
        this.paymentMethod = paymentMethod;
        this.order = order;
        this.dFactory = new DiscountFactory();
        this.total = 0;
        this.tax = 0;
    }

    public void checkout() {
        double subtotal = 0;
        for (FoodItem item : order.getItems()) {
            Discount discount = dFactory.getDiscount(item.getCategory());
            subtotal += discount.apply(item.getPrice());
        }

        this.tax = order.getTax();
        if (tax < 1) // that means it is a percentage
            tax *= subtotal;

        this.total = subtotal + tax;
        paymentMethod.pay(total);
    }

    public void generateBill() {
        for (var item : order.getItems()){
            System.out.println(item.getDescription() + ": " + item.getPrice() + "EGP");
            Discount discount = dFactory.getDiscount(item.getCategory());
            double discounted = discount.apply(item.getPrice());
            System.out.println("After discount: " + discounted + " EGP");
        }
        System.out.println(order.getType() + " " + this.tax);
        System.out.println("Total: " + this.total);
    }
    
    // setters/getters
    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }


    public void setOrder(Order order) {
        this.order = order;
    }
}
