package oc.p.tests.chapters._20.q._25;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentMap;
import java.util.stream.Collectors;

class Car {
    private String model;
    private int year;

    Car(final String model, final int year) {
        this.model = model;
        this.year = year;
    }

    int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return model;
    }

    public static void main(String[] args) {
        List<Car> cars = new ArrayList <>();

        cars.add(new Car("Mustang",1967));
        cars.add(new Car("Thunderbird",1967));
        cars.add(new Car("Escort",1975));

        final ConcurrentMap <Integer, List <Car>> collect = cars.stream()
                .collect(Collectors.groupingByConcurrent(Car::getYear));

        System.out.println(collect);
    }


}
