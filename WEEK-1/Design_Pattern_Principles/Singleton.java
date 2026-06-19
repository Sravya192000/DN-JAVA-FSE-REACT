public class Singleton {

    // Singleton Logger class
    static class Logger {

        // Single instance
        private static Logger instance;

        // Private constructor
        private Logger() {
            System.out.println("Logger instance created.");
        }

        // Method to get the single instance
        public static Logger getInstance() {

            if (instance == null) {
                instance = new Logger();
            }

            return instance;
        }

        // Logging method
        public void log(String message) {
            System.out.println("LOG: " + message);
        }
    }

    public static void main(String[] args) {

        Logger logger1 = Logger.getInstance();

        Logger logger2 = Logger.getInstance();

        logger1.log("Application started");

        logger2.log("User logged in");

        if (logger1 == logger2) {
            System.out.println("Only one Logger instance exists.");
        } else {
            System.out.println("Multiple Logger instances created.");
        }
    }
}