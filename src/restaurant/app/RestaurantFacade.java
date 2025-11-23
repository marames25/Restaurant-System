package restaurant.app;

import java.util.Scanner;

import restaurant.items.factory.ItemsFactory;
import restaurant.menu.handler.MenuHandler;
import restaurant.ordering.Order;
import restaurant.ordering.factory.OrderPlacer;
import restaurant.payment.methods.PaymentMethod;
import restaurant.payment.methods.factory.PaymentMethodFactory;
import restaurant.paymentProcessor.PaymentProcessor;

/**
 * Facade that encapsulates the full restaurant flow:
 * browse menu, customize meals, place order, process payment, generate bill.
 */
public class RestaurantFacade {

    public void start() {
        try (Scanner sc = new Scanner(System.in)) {
            // 1) Build menus and take orders
            MenuHandler mh = new MenuHandler();
            String[][] choices = mh.takeUserOrders(sc);

            // 2) Place order (choose type)
            OrderPlacer op = new OrderPlacer(ItemsFactory.getInstance());
            System.out.println("Please choose order type (Delivery / Dine-in / Takeaway):");
            String orderType = sc.nextLine().trim();
            Order order = op.placeOrder(choices, orderType);

            if (order.getItemsCount() == 0) {
                System.out.println("No items in the order. Exiting.");
                return;
            }

            // 3) Choose payment method and (if needed) collect details
            System.out.println("Choose payment method (card / cash / mobile):");
            String paymentChoice = sc.nextLine().trim();

            PaymentMethod pm;
            try {
                if (paymentChoice.equalsIgnoreCase("card")) {
                    System.out.print("Enter card number: ");
                    String cardNumber = sc.nextLine().trim();
                    pm = PaymentMethodFactory.getPaymentMethod("card", cardNumber);
                } else if (paymentChoice.equalsIgnoreCase("cash")) {
                    pm = PaymentMethodFactory.getPaymentMethod("cash");
                } else {
                    pm = PaymentMethodFactory.getPaymentMethod("mobile");
                }
            } catch (IllegalArgumentException ex) {
                System.out.println("Payment setup error: " + ex.getMessage());
                System.out.println("Aborting.");
                return;
            }

            // 4) Process payment and generate bill
            PaymentProcessor processor = new PaymentProcessor(pm, order);
            processor.checkout();

            System.out.println("\n---- RECEIPT ----");
            System.out.println("Order Type: " + order.getType());
            processor.generateBill();
        }
    }
}
