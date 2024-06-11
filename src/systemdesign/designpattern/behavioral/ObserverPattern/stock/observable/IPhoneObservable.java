package systemdesign.designpattern.behavioral.ObserverPattern.stock.observable;

import systemdesign.designpattern.behavioral.ObserverPattern.stock.observer.NotificationAlertObserver;

import java.util.ArrayList;
import java.util.List;

public class IPhoneObservable implements StockObservable {
    public List<NotificationAlertObserver> observerList = new ArrayList<>();
    public int stockCount = 0;

    @Override
    public void add(NotificationAlertObserver observer) {
        observerList.add(observer);
    }

    @Override
    public void remove(NotificationAlertObserver observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifySubscribers() {
        for (NotificationAlertObserver observer : observerList) {
            observer.update();
        }
    }

    @Override
    public void setStocks(int stocks) {
        if (stockCount == 0) {
            notifySubscribers();
        }
        stockCount = stockCount + stocks;
    }

    @Override
    public void clearStocks() {
        stockCount = 0;
    }

    @Override
    public int getStocks() {
        return stockCount;
    }
}
