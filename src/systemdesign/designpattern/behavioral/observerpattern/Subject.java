package systemdesign.designpattern.behavioral.observerpattern;


interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}
