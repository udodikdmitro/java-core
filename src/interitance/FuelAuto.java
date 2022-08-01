package interitance;

public abstract class FuelAuto extends Auto {
    private int availablePetrol;
    private int tankVolume;
    private int passengersNumbers;

    public FuelAuto(String producer, String model, Engine engine) {
        super(producer, model, engine);
        this.passengersNumbers = passengersNumbers;

    }


    public void fuelUp(int petrolVolume) {
        availablePetrol += petrolVolume;
        System.out.println("Adding petrol");
    }

    public int getAvailablePetrol() {
        return availablePetrol;
    }

    public int getTankVolume() {
        return tankVolume;
    }

    public void setAvailablePetrol(int availablePetrol) {
        this.availablePetrol = availablePetrol;
    }

    public void setTankVolume(int tankVolume) {
        this.tankVolume = tankVolume;
    }
}
