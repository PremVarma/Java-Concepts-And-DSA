package basics.compareInterfaces;

import java.util.Arrays;
import java.util.Comparator;

class Car {
    public final String name;
    public final String type;

    public Car(String name, String type) {
        this.name = name;
        this.type = type;
    }
}

public class CompareExamples {
    public static void main(String[] args) {
        Integer[] arr = {17, 4, 10, 1, 2};
        Arrays.sort(arr, (Integer v1, Integer v2) -> v2 - v1); // Uses Comparator as second parameter which has compare(o1,o2) as abstract class
        System.out.println(Arrays.toString(arr));

        Car[] cars = new Car[3];
        cars[0] = new Car("Suv", "Patrol");
        cars[1] = new Car("HatchBank", "CNG");
        cars[2] = new Car("Sedan", "Diesel");
        Comparator<Car> comparator = Comparator.comparing((car) -> car.name);
        Arrays.sort(cars, comparator);

        for (Car car : cars) {
            System.out.println(car.name + " => " + car.type);
        }
    }

    private static Comparator<Car> getCarComparator() {
        return (Car obj1, Car obj2) -> obj2.type.compareTo(obj1.type);
    }
}
