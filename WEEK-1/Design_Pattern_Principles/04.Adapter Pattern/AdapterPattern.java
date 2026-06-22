public class AdapterPattern {

    // Target Interface

    interface PaymentProcessor {
        void processPayment(double amount);
    }

    // Adaptee Classes (Third-party payment gateways)

    static class PayPalGateway {

        public void sendPayment(double amount) {
            System.out.println(
                    "Payment of Rs." + amount +
                            " processed through PayPal.");
        }
    }

    static class StripeGateway {

        public void makeTransaction(double amount) {
            System.out.println(
                    "Payment of Rs." + amount +
                            " processed through Stripe.");
        }
    }

    // Adapter for PayPal

    static class PayPalAdapter
            implements PaymentProcessor {

        private PayPalGateway payPal;

        public PayPalAdapter() {
            payPal = new PayPalGateway();
        }

        public void processPayment(
                double amount) {

            payPal.sendPayment(amount);
        }
    }

    // Adapter for Stripe

    static class StripeAdapter
            implements PaymentProcessor {

        private StripeGateway stripe;

        public StripeAdapter() {
            stripe = new StripeGateway();
        }

        public void processPayment(
                double amount) {

            stripe.makeTransaction(amount);
        }
    }

    // Main method

    public static void main(String[] args) {

        PaymentProcessor paypal = new PayPalAdapter();

        PaymentProcessor stripe = new StripeAdapter();

        paypal.processPayment(5000);

        stripe.processPayment(2500);
    }
}