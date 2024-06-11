package systemdesign.solidprinciple;


//class should depend on interface rather than concrete class
//high-level modules should not depend on low-level modules; both should depend on abstractions
public class EDependencyInversionPrinciple {
    public static void main(String[] args) {

    }
}

class LightBulb {
    public void turnOn() {
        System.out.println("Turn On");
    }

    public void turnOff() {
        System.out.println("Turn Off");
    }
}

class Switch {
    private LightBulb lightBulb; // We will have to add all device which have switch functionality as this is dependent on class
    // lets fix this to make this reusable

    public void Switch(LightBulb lightBulb) {
        this.lightBulb = lightBulb;
    }

    public void turnOn() {
        lightBulb.turnOn();
    }

    public void turnOff() {
        lightBulb.turnOff();
    }
}

// =========================DIP==============================

interface Switchable {
    void turnOff();

    void turnOn();
}

class LightBulbFix implements Switchable {

    @Override
    public void turnOff() {

    }

    @Override
    public void turnOn() {

    }
}

class SwitchFix {
    private Switchable switchable;

    public SwitchFix(Switchable switchable) {
        this.switchable = switchable;
    }

    public void turnOff() {
        switchable.turnOff();
    }

    public void turnOn() {
        switchable.turnOn();
    }
}