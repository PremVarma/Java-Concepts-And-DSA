package systemdesign.designpattern.behavioral.ChainOfResponsibility.atm;

public class PremiumAccountHandler extends AccountHandler {
    @Override
    protected boolean canHandle(int amount) {
        return amount <= 500;
    }

    @Override
    protected void handle(int amount) {
        System.out.println("Premium account: Withdrawal approved for $" + amount);
    }
}
