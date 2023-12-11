package systemdesign.designpattern.behavioral.ChainOfResponsibility.atm;

public class BasicAccountHandler extends AccountHandler {
    @Override
    protected boolean canHandle(int amount) {
        return amount <= 100;
    }

    @Override
    protected void handle(int amount) {
        System.out.println("Basic account: Withdrawal approved for $" + amount);
    }
}
