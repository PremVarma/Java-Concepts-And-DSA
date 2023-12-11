package systemdesign.designpattern.behavioral.observerpattern.stock.observable;

import systemdesign.designpattern.behavioral.observerpattern.stock.observer.NotificationAlertObserver;

public interface StockObservable {
    public void add(NotificationAlertObserver observer);

    public void remove(NotificationAlertObserver observer);

    public void notifySubscribers();

    public void setStocks(int stocks);

    public int getStocks();

    public void clearStocks();

}
