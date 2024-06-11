package systemdesign.designpattern.behavioral.ObserverPattern.weather;


public interface Subject {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObservers();
}
