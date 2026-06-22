import java.util.ArrayList;
import java.util.List;

public class ObserverPattern {

    // Observer Interface

    interface Observer {
        void update(String stockName, double price);
    }

    // Subject Interface

    interface Stock {

        void registerObserver(Observer observer);

        void removeObserver(Observer observer);

        void notifyObservers();
    }

    // Concrete Subject

    static class StockMarket implements Stock {

        private List<Observer> observers = new ArrayList<>();

        private String stockName;

        private double price;

        public StockMarket(String stockName) {

            this.stockName = stockName;
        }

        public void setPrice(double price) {

            this.price = price;

            notifyObservers();
        }

        public void registerObserver(
                Observer observer) {

            observers.add(observer);
        }

        public void removeObserver(
                Observer observer) {

            observers.remove(observer);
        }

        public void notifyObservers() {

            for (Observer observer : observers) {

                observer.update(
                        stockName,
                        price);
            }
        }
    }

    // Concrete Observer 1

    static class MobileApp
            implements Observer {

        public void update(
                String stockName,
                double price) {

            System.out.println(
                    "Mobile App: "
                            + stockName
                            + " price updated to Rs."
                            + price);
        }
    }

    // Concrete Observer 2

    static class WebApp
            implements Observer {

        public void update(
                String stockName,
                double price) {

            System.out.println(
                    "Web App: "
                            + stockName
                            + " price updated to Rs."
                            + price);
        }
    }

    // Main Method

    public static void main(String[] args) {

        StockMarket stock = new StockMarket("TCS");

        Observer mobile = new MobileApp();

        Observer web = new WebApp();

        stock.registerObserver(mobile);

        stock.registerObserver(web);

        stock.setPrice(4200);

        System.out.println();

        stock.setPrice(4350);
    }
}