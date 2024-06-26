package systemdesign.designpattern.behavioral.ObserverPattern.stock.observer;

import systemdesign.designpattern.behavioral.ObserverPattern.stock.observable.StockObservable;

public class EmailAlertObserverImpl implements NotificationAlertObserver {
    String emailId;
    StockObservable observable;

    public EmailAlertObserverImpl(String emailId, StockObservable observable) {
        this.emailId = emailId;
        this.observable = observable;
    }

    @Override
    public void update() {
        sendMail(emailId, "product is in stock hurry up");
    }

    private void sendMail(String emailId, String msg) {
        System.out.println("mail sent to : " + emailId);
    }
}
