package com.company;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        final CarGenerator carGenerator = new CarGenerator();

        final List<Car> cars = new ArrayList<>();
        for (int i = 0; i < 400; i++) {
            Car temp = carGenerator.generateCar();
            cars.add(temp);
        }
        System.out.println("These are all the generated cars:");
        cars.forEach(s -> System.out.println(s));

        List<Car> brandFilterCars = cars.stream()
                .filter(car -> car.getBrand().equals(Brand.Tesla) || car.getBrand().equals(Brand.Audi))
                .collect(Collectors.toList());
        System.out.println("\nTesla and Audi cars:");
        brandFilterCars.forEach(s -> System.out.println(s));

        List<Car> yearFilterCars = brandFilterCars.stream()
                .filter(car -> car.getYear() > 2018)
                .collect(Collectors.toList());
        System.out.println("\nTesla and Audi cars produced before 2018:");
        yearFilterCars.forEach(s -> System.out.println(s));

        List<Car> mileageFilterCars = yearFilterCars.stream()
                .filter(car -> car.getMileage() < 40000)
                .collect(Collectors.toList());
        System.out.println("\nTesla and Audi cars produced before 2018 and with mileage less than 40000:");
        mileageFilterCars.forEach(s -> System.out.println(s));

        List<Car> sortedCarsByPrice = mileageFilterCars.stream()
                .sorted(Comparator.comparingInt(Car::getPrice).reversed())
                .collect(Collectors.toList());
        System.out.println("\nTesla and Audi cars produced before 2018 and with mileage less than 40000 (sorted by price (max-min):");
        sortedCarsByPrice.forEach(s -> System.out.println(s));

        Map<UUID, Car> cheapestCars = sortedCarsByPrice.stream()
                .sorted(Comparator.comparingInt(Car::getPrice))
                .limit(3)
                .collect(Collectors.toMap(Car::getId, car -> car));
        System.out.println("\nTesla and Audi cars, three cheapest cars:");
        cheapestCars.forEach((id, car) -> System.out.println(id + ":" + car));
    }
}
