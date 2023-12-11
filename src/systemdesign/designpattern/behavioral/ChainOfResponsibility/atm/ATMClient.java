package systemdesign.designpattern.behavioral.ChainOfResponsibility.atm;

public class ATMClient {
    public static void main(String[] args) {
        AccountHandler basicAccountHandler = new BasicAccountHandler();
        AccountHandler premiumAccountHandler = new PremiumAccountHandler();

        basicAccountHandler.setNextHandler(premiumAccountHandler);

        // Initiating requests
        basicAccountHandler.handleRequest(50);
        basicAccountHandler.handleRequest(200);
        basicAccountHandler.handleRequest(600);
    }
}
