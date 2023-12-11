package systemdesign.designpattern.behavioral.ChainOfResponsibility.atm;

public abstract class AccountHandler implements WithdrawalHandler {
    private WithdrawalHandler nextHandler;

    @Override
    public void setNextHandler(WithdrawalHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    @Override
    public void handleRequest(int amount) {
        if (canHandle(amount)) {
            handle(amount);
        } else if (nextHandler != null) {
            nextHandler.handleRequest(amount);
        } else {
            System.out.println("Transaction failed. Insufficient funds.");
        }
    }

    protected abstract boolean canHandle(int amount);
    protected abstract void handle(int amount);
}
