package systemdesign.designpattern.behavioral.ObserverPattern.product;

import java.util.ArrayList;
import java.util.List;

// Concrete subject: Product
public class Product implements Subject {
    private String productName;
    private boolean isAvailable;
    private List<Observer> observers;

    public Product(String productName) {
        this.productName = productName;
        this.observers = new ArrayList<>();
        this.isAvailable = true; // Initially, the product is available
    }

    public void setAvailability(boolean isAvailable) {
        if (this.isAvailable != isAvailable) {
            this.isAvailable = isAvailable;
            notifyObservers();
        }
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(productName, isAvailable);
        }
    }
}
