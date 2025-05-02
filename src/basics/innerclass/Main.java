package basics.innerclass;

public class Main {
    public static void main(String[] args) {
        Car car = new Car("Tata Safari");
        Car.Engine engine = car.new Engine();
        engine.start();
        engine.start();
        engine.stop();

//     Static inner class
        Computer computer = new Computer("HP", "i9-5510");
        computer.getOs().displayInfo();
        Computer.USB usb = new Computer.USB("TYPE-C");
        usb.displayInfo();

//      Anonymous class
        ShoppingCart shoppingCart = new ShoppingCart(150);
        shoppingCart.processPayment(new Payment() {
            @Override
            public void pay(double amount) {
                System.out.println("Paying.....");
            }
        });

//      Local class
        Hotel hotel = new Hotel("Taj", 10, 5);
        hotel.reserveRoom("Prem", 5);
        hotel.reserveRoom("Shubham", 1);
    }
}
