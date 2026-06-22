public class ProxyPattern {

    // Subject Interface

    interface Image {
        void display();
    }

    // Real Subject

    static class RealImage implements Image {

        private String fileName;

        public RealImage(String fileName) {

            this.fileName = fileName;

            loadFromServer();
        }

        private void loadFromServer() {

            System.out.println(
                    "Loading " + fileName +
                            " from remote server...");
        }

        public void display() {

            System.out.println(
                    "Displaying " + fileName);
        }
    }

    // Proxy Class

    static class ProxyImage implements Image {

        private String fileName;

        private RealImage realImage;

        public ProxyImage(String fileName) {

            this.fileName = fileName;
        }

        public void display() {

            // Lazy initialization

            if (realImage == null) {

                realImage = new RealImage(fileName);
            }

            // Display image

            realImage.display();
        }
    }

    // Main Method

    public static void main(String[] args) {

        Image image = new ProxyImage("sample.jpg");

        System.out.println(
                "First time:");

        image.display();

        System.out.println();

        System.out.println(
                "Second time:");

        image.display();
    }
}