public class StrategyPattern {

    // Strategy Interface

    interface PaymentStrategy {

        void pay(double amount);
    }

    // Concrete Strategy 1

    static class CreditCardPayment
            implements PaymentStrategy {

        public void pay(double amount) {

            System.out.println(
                    "Paid Rs." + amount
                            + " using Credit Card.");
        }
    }

    // Concrete Strategy 2

    static class PayPalPayment
            implements PaymentStrategy {

        public void pay(double amount) {

            System.out.println(
                    "Paid Rs." + amount
                            + " using PayPal.");
        }
    }

    // Context Class

    static class PaymentContext {

        private PaymentStrategy strategy;

        public void setPaymentStrategy(
                PaymentStrategy strategy) {

            this.strategy = strategy;
        }

        public void executePayment(
                double amount) {

            strategy.pay(amount);
        }
    }

    // Main Method

    public static void main(String[] args) {

        PaymentContext context = new PaymentContext();

        // Credit Card Payment

        context.setPaymentStrategy(
                new CreditCardPayment());

        context.executePayment(5000);

        // PayPal Payment

        context.setPaymentStrategy(
                new PayPalPayment());

        context.executePayment(2500);
    }
}