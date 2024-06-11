package systemdesign.designpattern.behavioral.ObserverPattern;

import systemdesign.designpattern.behavioral.ObserverPattern.product.Customer;
import systemdesign.designpattern.behavioral.ObserverPattern.product.Product;
import systemdesign.designpattern.behavioral.ObserverPattern.stock.observable.IPhoneObservable;
import systemdesign.designpattern.behavioral.ObserverPattern.stock.observable.StockObservable;
import systemdesign.designpattern.behavioral.ObserverPattern.stock.observer.EmailAlertObserverImpl;
import systemdesign.designpattern.behavioral.ObserverPattern.stock.observer.MobileAlertObserverImpl;
import systemdesign.designpattern.behavioral.ObserverPattern.stock.observer.NotificationAlertObserver;

public class Main {
    public static void main(String[] args) {
        // Create a product
        Product smartphone = new Product("Smartphone");

        // Create customers (observers)
        Customer customer1 = new Customer("Alice");
        Customer customer2 = new Customer("Bob");

        // Register customers as observers for the product
        smartphone.addObserver(customer1);
        smartphone.addObserver(customer2);

        // Simulate the product going out of stock
        smartphone.setAvailability(false);

        // Simulate the product becoming available
        smartphone.setAvailability(true);

//        Stocks
        System.out.println("-----------STOCK EXAMPLE-----------------");
        StockObservable iPhoneObservable = getStockObservable();

        iPhoneObservable.setStocks(10);
        iPhoneObservable.clearStocks();
        iPhoneObservable.setStocks(100);

    }

    private static StockObservable getStockObservable() {
        StockObservable iPhoneObservable = new IPhoneObservable();

        NotificationAlertObserver observer1 = new EmailAlertObserverImpl("prem@gmail.com", iPhoneObservable);
        NotificationAlertObserver observer2 = new EmailAlertObserverImpl("ramesh@gmail.com", iPhoneObservable);
        NotificationAlertObserver observer3 = new MobileAlertObserverImpl("ramesh@gmail.com", iPhoneObservable);

        iPhoneObservable.add(observer1);
        iPhoneObservable.add(observer2);
        iPhoneObservable.add(observer3);
        return iPhoneObservable;
    }
}
