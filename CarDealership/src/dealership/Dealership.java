package dealership;

import java.util.ArrayList;
import java.util.List;

public class Dealership {

    private String name;
    private int capacity;
    private List<Car> data;

    public Dealership(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (this.data.size() < capacity) {
            this.data.add(car);
        }
    }

    public boolean buy(String manufacturer, String model) {
        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).getManufacturer().equals(manufacturer) &&
                    this.data.get(i).getModel().equals(model)) {
                this.data.remove(i);
                return true;
            }
        }
        return false;
    }

    public Car getLatestCar() {
        Car car = null;
        int max = Integer.MIN_VALUE;
        for (Car datum : data) {
            if (datum.getYear() > max) {
                max = datum.getYear();
                car = datum;
            }
        }
        return car;
    }

    public Car getCar(String manufacturer, String model) {
        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).getManufacturer().equals(manufacturer) &&
                    this.data.get(i).getModel().equals(model)) {
                return this.data.get(i);
            }
        }
        return null;
    }
    public int getCount(){
        return this.data.size();
    }
    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The cars are in a car dealership %s:",this.name)).append(System.lineSeparator());
        for (Car datum : data) {
            sb.append(datum).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
