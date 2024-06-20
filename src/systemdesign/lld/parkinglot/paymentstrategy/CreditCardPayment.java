package systemdesign.lld.parkinglot.paymentstrategy;

public class CreditCardPayment implements PaymentStrategy {
    @Override
    public void processPayment(int amount) {
        System.out.println("Processing credit card payment of INR." + amount);
    }
}
