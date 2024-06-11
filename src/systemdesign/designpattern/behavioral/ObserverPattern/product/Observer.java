package systemdesign.designpattern.behavioral.ObserverPattern.product;

public interface Observer {
    void update(String productName, boolean isAvailable);
}

