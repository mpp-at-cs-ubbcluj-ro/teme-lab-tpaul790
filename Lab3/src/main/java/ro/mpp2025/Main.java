package ro.mpp2025;


import org.checkerframework.checker.units.qual.C;
import ro.mpp2025.domain.Car;
import ro.mpp2025.repository.CarRepository;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        Properties props=new Properties();
        try {
            props.load(new FileReader("Lab3/bd.config"));
        } catch (IOException e) {
            System.out.println("Cannot find bd.config "+e);
        }

        CarRepository carRepo=new CarRepository(props);

        carRepo.save(new Car("Tesla","DSL", 2012));

        Car tesla = new Car("Tesla", "DSL",2100);
        tesla.setId(3);
        carRepo.update(tesla);
        System.out.println("Toate masinile din care merg pe dsl");
        for(Car car:carRepo.findAll())
            System.out.println(car);

    }
}