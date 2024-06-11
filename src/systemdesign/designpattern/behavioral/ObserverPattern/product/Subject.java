package systemdesign.designpattern.behavioral.ObserverPattern.product;


interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
