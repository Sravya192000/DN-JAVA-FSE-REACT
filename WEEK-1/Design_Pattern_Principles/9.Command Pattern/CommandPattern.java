public class CommandPattern {

    // Command Interface

    interface Command {

        void execute();
    }

    // Receiver Class

    static class Light {

        public void turnOn() {

            System.out.println(
                    "Light is ON");
        }

        public void turnOff() {

            System.out.println(
                    "Light is OFF");
        }
    }

    // Concrete Command 1

    static class LightOnCommand
            implements Command {

        private Light light;

        public LightOnCommand(
                Light light) {

            this.light = light;
        }

        public void execute() {

            light.turnOn();
        }
    }

    // Concrete Command 2

    static class LightOffCommand
            implements Command {

        private Light light;

        public LightOffCommand(
                Light light) {

            this.light = light;
        }

        public void execute() {

            light.turnOff();
        }
    }

    // Invoker Class

    static class RemoteControl {

        private Command command;

        public void setCommand(
                Command command) {

            this.command = command;
        }

        public void pressButton() {

            command.execute();
        }
    }

    // Main Method

    public static void main(String[] args) {

        Light light = new Light();

        RemoteControl remote = new RemoteControl();

        // Turn ON

        remote.setCommand(
                new LightOnCommand(light));

        remote.pressButton();

        // Turn OFF

        remote.setCommand(
                new LightOffCommand(light));

        remote.pressButton();
    }
}