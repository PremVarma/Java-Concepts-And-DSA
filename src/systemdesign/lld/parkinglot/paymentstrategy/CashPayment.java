package systemdesign.lld.parkinglot.paymentstrategy;

public class CashPayment implements PaymentStrategy {
    @Override
    public void processPayment(int amount) {
        System.out.println("Processing cash payment of INR." + amount);
    }
}