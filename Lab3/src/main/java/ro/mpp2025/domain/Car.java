package ro.mpp2025.domain;

public class Car extends Entity<Integer> {
    private String brand;
    private String fuel;
    private int mileage;

    public Car(String brand, String fuel, int mileage){
        this.brand = brand;
        this.fuel = fuel;
        this.mileage = mileage;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    @Override
    public String toString() {
        return brand + " " + fuel + " " + mileage;
    }
}
