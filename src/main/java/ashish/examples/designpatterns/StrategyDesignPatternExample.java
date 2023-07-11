package ashish.examples.designpatterns;

public class StrategyDesignPatternExample {
    VehicleStrategy vehicle;
    StrategyDesignPatternExample(VehicleStrategy vehicle){
        this.vehicle = vehicle;
    }

    public void drive() {
        this.vehicle.drive();
    }

    public static void main(String[] args) {
        StrategyDesignPatternExample strategy = new StrategyDesignPatternExample(new SportsVehicle());
        //StrategyDesignPatternExample strategy = new StrategyDesignPatternExample(new SportsVehicle());
        strategy.drive();
    }

}

interface VehicleStrategy{
    void drive();
}

class PassengerVehicle implements VehicleStrategy{
    @Override
    public void drive() {
        System.out.println("Basic Commuter Drive.");
    }
}

class SportsVehicle implements VehicleStrategy{
    @Override
    public void drive() {
        System.out.println("Sporty Drive.");
    }
}
