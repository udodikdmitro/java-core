package set;

import collections.Card;

import java.util.*;

public class SetRunner {

    public static void main(String[] args) {

        String[] cars = {"Mini", "Mercedes-Benz", "Audi", "VW", "Smart", "Toyota", "Porsche"};
        String[] otherCars = {"Audi", "Ford", "GMC", "Toyota", "Chevrolet"};

        Set<String> carSet = new TreeSet<>(Arrays.asList(cars));
        Set<String> otherCarSet = new TreeSet<>(Arrays.asList(otherCars));
        Set<String> uniqueCars = new TreeSet<>(carSet);

        Set<Car> sixCars = new HashSet<>();
        sixCars.add(new Car("VW","Golf",45));
        sixCars.add(new Car("Audi","A3",60));
        sixCars.add(new Car("VW","Polo",35));
        sixCars.add(new Car("BMW","Z4",120));
        sixCars.add(new Car("BMW","440i",200));

        Set<Car> europaCars = new HashSet<>();
        europaCars.add(new Car("Toyota","Auris",40));
        europaCars.add(new Car("Renault","Clio",30));
        europaCars.add(new Car("Renault","Megan",50));
        europaCars.add(new Car("VW","Golf",45));
        europaCars.add(new Car("VW","Polo",35));

        uniqueCars.addAll(otherCarSet);

        NavigableSet<Car> uniqueCar = new TreeSet<>(sixCars);
        uniqueCar.addAll(europaCars);

        SortedSet<Car> car1 = uniqueCar.subSet(new Car("Toyota", "Auris", 40), true,
                new Car("Audi", "A3", 60), true);

        print(uniqueCar);

        System.out.println("Higher");
        System.out.println(uniqueCar.higher(new Car("Toyota", "Auris", 40)));

        System.out.println("Lower");
        System.out.println(uniqueCar.lower(new Car("Toyota", "Auris", 40)));

        System.out.println("Floor");
        System.out.println(uniqueCar.floor(new Car("Toyota", "Auris", 40)));

    }

    public static void print(Set<Car> cars){
        System.out.printf("%-20s %-20s %-20s \n", "Car brand", "Model", "Price per day");
        for (Car car : cars) {
            System.out.printf("%-20s %-20s %-20s \n", car.getCarBrand(), car.getModel(), car.getPricePerDay());
        }
    }
}
