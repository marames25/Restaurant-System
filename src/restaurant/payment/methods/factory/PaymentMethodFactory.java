package restaurant.payment.methods.factory;

import restaurant.payment.methods.Card;
import restaurant.payment.methods.Cash;
import restaurant.payment.methods.MobileWallet;
import restaurant.payment.methods.PaymentMethod;

public class PaymentMethodFactory {

    public static PaymentMethod getPaymentMethod(String type) {
        return getPaymentMethod(type, null);
    }

    public static PaymentMethod getPaymentMethod(String type, String identifier) {
        if (type == null) {
            throw new IllegalArgumentException("Payment type cannot be null");
        }

        switch (type.trim().toLowerCase()) {
            case "card":
                return new Card();
            case "cash":
                return new Cash();
            case "mobile":
            case "mobilewallet":
            case "wallet":
                return new MobileWallet();
            default:
                throw new IllegalArgumentException("Unknown payment type: " + type);
        }
    }
}
