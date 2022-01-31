package parking;

import java.util.ArrayList;
import java.util.List;

public class Parking {
    private String type;
    private int capacity;
    private List<Car> data;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car) {
        if (this.data.size() < capacity) {
            this.data.add(car);
        }
    }

    public boolean remove(String manufacturer, String model) {
        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).getManufacturer().equals(manufacturer)
                    && this.data.get(i).getModel().equals(model)) {
                this.data.remove(i);
                return true;
            }
        }
        return false;
    }

    public Car getLatestCar() {
        Car car = null;
        if (this.data.isEmpty()) {
            return null;
        } else {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < this.data.size(); i++) {
                if (this.data.get(i).getYear() > max) {
                    max = this.data.get(i).getYear();
                    car = this.data.get(i);
                }
            }
            return car;
        }

    }

    public Car getCar(String manufacturer, String model) {
        Car car = null;
        if (this.data.isEmpty()) {
            return null;
        } else {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < this.data.size(); i++) {
                if (this.data.get(i).getManufacturer().equals(manufacturer)
                        && this.data.get(i).getModel().equals(model)) {
                    car = this.data.get(i);
                    break;
                }
            }
        }
        return car;
    }

    public int getCount() {
        return this.data.size();
    }


    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The cars are parked in %s:", this.type)).append(System.lineSeparator());
        for (Car datum : data) {
            sb.append(datum).append(System.lineSeparator());

        }
        return sb.toString();
    }
}


//•	getStatistics() – returns a String in the following format:
//o	"The cars are parked in {parking type}:
//{Car1}
//{Car2}
//(…)"