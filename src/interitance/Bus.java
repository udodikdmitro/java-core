package interitance;

public class Bus extends FuelAuto {
    private int passengerNumber;

    public Bus(String producer, String model, Engine engine, int passengerNumber) {
        super(producer, model, engine);
        this.passengerNumber = passengerNumber;
        System.out.println("Bus was initialised");
    }

    public void fuelUp() {
        int volume = getTankVolume() - getAvailablePetrol();
        fuelUp(volume);
    }

    @Override
    public void fuelUp(int petrolVolume) {
        int volume = getAvailablePetrol() + petrolVolume;
        if (volume > getTankVolume()) {
            setAvailablePetrol(getTankVolume());
        }
    }

    public int getPassengerNumber() {
        return passengerNumber;
    }

    @Override
    public void start() {
        isRunning = true;
        setCurrentSpeed(10);
        System.out.println("Bus is starting");

    }
    @Override
    public void energize() {
        fuelUp(getTankVolume()-getAvailablePetrol());
    }


    @Override
    public void stop() {
        isRunning = false;
        setCurrentSpeed(10);
        System.out.println("Bus has stopped");
    }


    public void setPassengerNumber(int passengerNumber) {
        this.passengerNumber = passengerNumber;
    }

    public void pickUpPassengers(int passengerNum) {
        this.passengerNumber = passengerNum;
        System.out.println("Picking up " + passengerNum + " passengers");
    }

    public void releasePassengers() {
        if (isRunning()) {
            stop();
        }
        passengerNumber = 0;
        System.out.println("Passengers are released");
    }
}
