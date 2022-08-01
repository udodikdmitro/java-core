package interitance;

public class Truck extends FuelAuto {
    private int chargeWeight;

    public int getChargeWeight() {
        return chargeWeight;
    }

    public void setChargeWeight(int chargeWeight) {
        this.chargeWeight = chargeWeight;
    }

    public Truck(String producer, String model, Engine engine, int chargeWeight) {
        super(producer, model, engine);
        this.chargeWeight = chargeWeight;
        System.out.println("Constructing truck");
    }

    public void load() {
        System.out.println("Truck is load");
    }

    public void unload() {
        System.out.println("Truck is unload");
    }

    @Override
    public void start() {
        isRunning = true;
        setCurrentSpeed(10);
        System.out.println("Truck is starting");

    }

    @Override
    public void energize() {
        fuelUp(getTankVolume()-getAvailablePetrol());
    }

    @Override
    public void stop() {
        isRunning = false;
        setCurrentSpeed(10);
        System.out.println("Truck has stopped");
    }

}
