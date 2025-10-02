interface Vehicle { void drive(); }

class Car implements Vehicle { public void drive() { System.out.println("Driving Car"); } }
class Bike implements Vehicle { public void drive() { System.out.println("Riding Bike"); } }

class VehicleFactory {
    public static Vehicle createVehicle(String type) {
        if (type.equalsIgnoreCase("car")) return new Car();
        else if (type.equalsIgnoreCase("bike")) return new Bike();
        return null;
    }
}

public class FactoryDemo {
    public static void main(String[] args) {
        Vehicle v = VehicleFactory.createVehicle("car");
        v.drive();
    }
}
