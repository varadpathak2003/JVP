class Vehicle {
    void start() {
        System.out.println("Vehicle is starting.");
    }
    // Method Overloading
    void start(String engine) {
        System.out.println(engine+" engine of the vehicle has started");
    }
}
// Subclass inheriting from Vehicle
class Car extends Vehicle {
    // Method Overriding
    @Override
    void start() {
        System.out.println("Car started");
    }
}
public class Main {
    public static void main(String[] args) {
        Vehicle v = new Vehicle();
        v.start();
        v.start("diesel"); 

        Car c = new Car();
        c.start();
    }
}
