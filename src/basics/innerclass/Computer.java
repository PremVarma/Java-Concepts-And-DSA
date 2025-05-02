package basics.innerclass;

public class Computer {
    private String brand;
    private String model;
    private OperatingSystem os;

    public Computer(String brand, String model) {
        this.brand = brand;
        this.model = model;
        this.os = new OperatingSystem("Windows 11");
    }

    public OperatingSystem getOs() {
        return os;
    }

    static class USB {
        private String info;

        public USB(String info) {
            this.info = info;
        }

        public void displayInfo() {
            System.out.println("USB info: " + info);
        }
    }

    public class OperatingSystem {
        private String name;

        public OperatingSystem(String name) {
            this.name = name;
        }

        public void displayInfo() {
            System.out.println("Computer model: " + model + ", OS: " + name);
        }
    }
}
