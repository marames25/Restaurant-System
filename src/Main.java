//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.util.List;
import java.util.Scanner;

import restaurant.items.FoodItem;
import restaurant.items.factory.ItemsFactory;
import restaurant.menu.handler.MenuHandler;
import restaurant.ordering.Order;
import restaurant.ordering.factory.OrderPlacer;
import restaurant.payment.methods.PaymentMethod;
import restaurant.payment.methods.factory.PaymentMethodFactory;
import restaurant.paymentProcessor.PaymentProcessor;

public class Main {
    public static void main(String[] args) {
        // 1) Build menus and take orders (main item + add-ons)
        MenuHandler mh = new MenuHandler();
        String[][] choices = mh.takeUserOrders();

        // 2) Place order (choose type)
        OrderPlacer op = new OrderPlacer(ItemsFactory.getInstance());

        System.out.println("Please choose order type (Delivery / Dine-in / Takeaway):");
        Scanner sc = new Scanner(System.in);
        String orderType = sc.nextLine().trim();

        Order order = op.placeOrder(choices, orderType);

        if (order.getItemsCount() == 0) {
            System.out.println("No items in the order. Exiting.");
            sc.close();
            return;
        }

        // 3) Choose payment method and (if needed) collect details
        System.out.println("Choose payment method (card / cash / mobile):");
        String paymentChoice = sc.nextLine().trim();

        PaymentMethod pm;
        try {
            pm = PaymentMethodFactory.getPaymentMethod(paymentChoice);
        } catch (IllegalArgumentException ex) {
            System.out.println("Payment setup error: " + ex.getMessage());
            sc.close();
            return;
        }

        // 4) Process payment and generate bill
        PaymentProcessor processor = new PaymentProcessor(pm, order);
        processor.checkout();

        System.out.println("\n---- RECEIPT ----");
        System.out.println("Order Type: " + order.getType());
        processor.generateBill();

        sc.close();
    }
}