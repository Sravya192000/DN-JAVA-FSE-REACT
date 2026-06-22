public class DecoratorPattern {

    // Component Interface

    interface Notifier {
        void send(String message);
    }

    // Concrete Component

    static class EmailNotifier implements Notifier {

        public void send(String message) {

            System.out.println(
                    "Email Notification: " + message);
        }
    }

    // Abstract Decorator

    static abstract class NotifierDecorator
            implements Notifier {

        protected Notifier notifier;

        public NotifierDecorator(
                Notifier notifier) {

            this.notifier = notifier;
        }

        public void send(String message) {

            notifier.send(message);
        }
    }

    // SMS Decorator

    static class SMSNotifierDecorator
            extends NotifierDecorator {

        public SMSNotifierDecorator(
                Notifier notifier) {

            super(notifier);
        }

        public void send(String message) {

            super.send(message);

            System.out.println(
                    "SMS Notification: " + message);
        }
    }

    // Slack Decorator

    static class SlackNotifierDecorator
            extends NotifierDecorator {

        public SlackNotifierDecorator(
                Notifier notifier) {

            super(notifier);
        }

        public void send(String message) {

            super.send(message);

            System.out.println(
                    "Slack Notification: " + message);
        }
    }

    // Main Method

    public static void main(String[] args) {

        Notifier notifier = new SlackNotifierDecorator(

                new SMSNotifierDecorator(

                        new EmailNotifier()));

        notifier.send(
                "Your order has been placed.");
    }
}