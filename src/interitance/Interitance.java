package interitance;

import java.util.List;

public class Interitance {
    public static void main(String[] args) {

        Engine truckEngine = new Engine(6.0, EngineType.DIESEL, 440);


        Truck truck = new Truck("Scania", "G44", truckEngine, 30000);

        System.out.println(truck.getProducer() + truck.getModel() + truck.getEngine());
        truck.start();
        truck.accceleration(40);
        truck.stop();
        truck.fuelUp(50);
        truck.load();
        truck.unload();

        System.out.println("/n");

        ElecricCar car = new ElecricCar("Tesla", "Model S", 10050, 4);
        car.start();
        car.accceleration(100);
        car.stop();
        car.charge();

        System.out.println("/n");

        Engine busEngine = new Engine(2, EngineType.DIESEL, 150);

        Bus bus = new Bus("Mercedes", "Sprinter", busEngine, 15);
        bus.fuelUp();
        bus.pickUpPassengers(5);
        bus.start();
        bus.releasePassengers();


        Engine engine = bus.getEngine();
        System.out.println(engine.getEngineType());
        List<Piston> pistons = engine.getPistons();
        System.out.println(pistons);


        Auto truck2 = new Truck("Scania", "G44", truckEngine, 30000);
        FuelAuto truck3 = new Truck("Scania", "G44", truckEngine, 30000);
        Auto bus2 = new Bus("Mercedes", "Sprinter", busEngine, 15);
        Auto car2 = new ElecricCar("Tesla", "Model S", 100500, 4);
//        Auto auto=new Auto("WV", "Polo",busEngine);

        bus2.start();
        bus2.stop();
//        bus2.fuelUp();    !!Don't resolve method!!
        truck2.start();
        truck2.stop();
        runCar(bus2);
        runCar(truck2);
        runCar(car2);
//        runCar(auto);

    }
    public static void runCar(Auto auto) {
        auto.start();
        auto.stop();
        auto.energize();
    }
}
