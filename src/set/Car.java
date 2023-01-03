package set;

import java.util.Objects;

public class Car implements Comparable<Car>{

    private final String carBrand;
    private final String model;
    private final int pricePerDay;

    public Car(String carBrand, String model, int pricePerDay) {
        this.carBrand = carBrand;
        this.model = model;
        this.pricePerDay = pricePerDay;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public String getModel() {
        return model;
    }

    public int getPricePerDay() {
        return pricePerDay;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return pricePerDay == car.pricePerDay && Objects.equals(carBrand, car.carBrand)
                && Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carBrand, model, pricePerDay);
    }

    @Override
    public int compareTo(Car car) {

        if (pricePerDay < car.getPricePerDay()) {
            return -1;
        }

        if (pricePerDay > car.getPricePerDay()) {
            return 1;
        }
        return 0;
    }

    @Override
    public String toString() {
        return carBrand + " " + model + " " + pricePerDay;
    }
}
