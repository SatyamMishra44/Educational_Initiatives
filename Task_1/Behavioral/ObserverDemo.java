import java.util.*;

interface Subject { void register(Observer o); void unregister(Observer o); void notifyObservers(); }
interface Observer { void update(float temperature); }

class WeatherStation implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private float temperature;

    public void setTemperature(float temperature) { this.temperature = temperature; notifyObservers(); }
    public void register(Observer o) { observers.add(o); }
    public void unregister(Observer o) { observers.remove(o); }
    public void notifyObservers() { for (Observer o : observers) o.update(temperature); }
}

class MobileApp implements Observer {
    public void update(float temperature) { System.out.println("Mobile App: Temperature updated to " + temperature); }
}

public class ObserverDemo {
    public static void main(String[] args) {
        WeatherStation station = new WeatherStation();
        MobileApp app = new MobileApp();
        station.register(app);
        station.setTemperature(30);
    }
}
