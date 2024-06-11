package systemdesign.designpattern.behavioral.ObserverPattern.stock.observer;

import systemdesign.designpattern.behavioral.ObserverPattern.stock.observable.StockObservable;

public class MobileAlertObserverImpl implements NotificationAlertObserver {
    String userName;
    StockObservable observable;

    public MobileAlertObserverImpl(String userName, StockObservable observable) {
        this.userName = userName;
        this.observable = observable;
    }

    @Override
    public void update() {
        sendMessage(userName, "product is in stock hurry up!");
    }

    private void sendMessage(String userName, String msg) {
        System.out.println("Messsage sent to : " + userName);
    }
}
