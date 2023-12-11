package systemdesign.designpattern.behavioral.ChainOfResponsibility.atm;

public interface WithdrawalHandler {
    void setNextHandler(WithdrawalHandler nextHandler);
    void handleRequest(int amount);
}
