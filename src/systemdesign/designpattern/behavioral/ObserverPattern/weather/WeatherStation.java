package systemdesign.designpattern.behavioral.ObserverPattern.weather;

public class WeatherStation {
    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionDisplay currentConditionDisplay = new CurrentConditionDisplay(weatherData);
        weatherData.setMeasurements(32.2f, 65, 34.5f);
    }
}
