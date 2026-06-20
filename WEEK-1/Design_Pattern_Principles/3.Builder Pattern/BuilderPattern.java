public class BuilderPattern {

    static class Computer {

        private String CPU;
        private int RAM;
        private int Storage;
        private String GraphicsCard;

        // Private constructor
        private Computer(Builder builder) {

            this.CPU = builder.CPU;
            this.RAM = builder.RAM;
            this.Storage = builder.Storage;
            this.GraphicsCard = builder.GraphicsCard;
        }

        // Display method
        public void display() {

            System.out.println("CPU: " + CPU);

            System.out.println("RAM: " + RAM + " GB");

            System.out.println("Storage: " + Storage + " GB");

            System.out.println(
                    "Graphics Card: " + GraphicsCard);

            System.out.println();
        }

        // Static nested Builder class

        static class Builder {

            private String CPU;
            private int RAM;
            private int Storage;
            private String GraphicsCard;

            public Builder setCPU(String CPU) {

                this.CPU = CPU;

                return this;
            }

            public Builder setRAM(int RAM) {

                this.RAM = RAM;

                return this;
            }

            public Builder setStorage(int Storage) {

                this.Storage = Storage;

                return this;
            }

            public Builder setGraphicsCard(
                    String GraphicsCard) {

                this.GraphicsCard = GraphicsCard;

                return this;
            }

            public Computer build() {

                return new Computer(this);
            }
        }
    }

    public static void main(String[] args) {

        Computer computer1 = new Computer.Builder()

                .setCPU("Intel i5")

                .setRAM(8)

                .setStorage(512)

                .setGraphicsCard("NVIDIA GTX 1650")

                .build();

        Computer computer2 = new Computer.Builder()

                .setCPU("Intel i7")

                .setRAM(16)

                .setStorage(1024)

                .setGraphicsCard("NVIDIA RTX 4060")

                .build();

        System.out.println(
                "Computer 1 Configuration:");

        computer1.display();

        System.out.println(
                "Computer 2 Configuration:");

        computer2.display();
    }
}