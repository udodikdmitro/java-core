package interitance;

public class ElecricCar extends Auto {
    private int electricVolume;
    private int passengersNumbers;

    public ElecricCar(String producer, String model, int electricVolume, int passengersNumbers) {
        super(producer, model, new Engine());
        this.electricVolume = electricVolume;
        this.passengersNumbers = passengersNumbers;
    }

    public int getElectricVolume() {
        return electricVolume;
    }

    public void setElectricVolume(int electricVolume) {
        this.electricVolume = electricVolume;
    }

    public int getPassengersNumbers() {
        return passengersNumbers;
    }

    public void setPassengersNumbers(int passengersNumbers) {
        this.passengersNumbers = passengersNumbers;
    }

    public void charge() {
        System.out.println("Battery is charge");
    }

    @Override
    public void start() {
        isRunning = true;
        setCurrentSpeed(10);
        System.out.println("Car is starting");

    }

    @Override
    public void stop() {
        isRunning = false;
        setCurrentSpeed(10);
        System.out.println("Car has stopped");
    }

    @Override
    public void energize() {
        Auto.doSmth();
        charge();
    }
}


