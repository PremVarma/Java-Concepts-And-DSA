package basics.innerclass;

public class Car {
    private String model;
    private boolean engineOn;

    public Car(String model) {
        this.model = model;
        this.engineOn = false;
    }

    class Engine {
        void start() {
            if (!engineOn) {
                engineOn = true;
                System.out.println(model + " Engine Started..");
            }else {
                System.out.println("Engine is already on..");
            }
        }

        void stop() {
            if (engineOn) {
                engineOn = false;
                System.out.println(model + " Engine Stopped..");
            }else {
                System.out.println("Engine already stopped...");
            }
        }
    }
}
