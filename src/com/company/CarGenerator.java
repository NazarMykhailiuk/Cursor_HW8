package com.company;

import java.util.Random;
import java.util.UUID;

public class CarGenerator {

    private Brand brand;
    private int year;
    private int mileage;
    private int price;

    public Car generateCar() {
        Random random = new Random();
        UUID id = UUID.randomUUID();
        brand = Brand.values()[new Random().nextInt(5)];
        year = 2008 + new Random().nextInt(13);
        mileage = new Random().nextInt(300001);
        price = new Random().nextInt(40001) + 2000;
        return new Car(id, brand, year, mileage, price);
    }

}


