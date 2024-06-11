package systemdesign.designpattern.behavioral.ObserverPattern.stock.observable;

import systemdesign.designpattern.behavioral.ObserverPattern.stock.observer.NotificationAlertObserver;

public interface StockObservable {
    public void add(NotificationAlertObserver observer);

    public void remove(NotificationAlertObserver observer);

    public void notifySubscribers();

    public void setStocks(int stocks);

    public int getStocks();

    public void clearStocks();

}
