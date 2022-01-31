package groomingSalon;

import java.util.ArrayList;
import java.util.List;

public class GroomingSalon {
    private int capacity;
    private List<Pet> data;

    public GroomingSalon(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet) {
        if (this.data.size() < capacity) {
            this.data.add(pet);
        }
    }

    public boolean remove(String name) {
        for (Pet datum : data) {
            if (datum.getName().equals(name)) {
                this.data.remove(datum);
                return true;
            }
        }
        return false;
    }

    public Pet getPet(String name, String owner) {
        Pet pet = null;
        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).getName().equals(name) && this.data.get(i).getOwner().equals(owner)) {
                pet = this.data.get(i);
            }
        }
        return pet;
    }
    public int getCount(){
        return this.data.size();
    }
    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("The grooming salon has the following clients:")).append(System.lineSeparator());
        for (Pet datum : data) {
            sb.append(datum.getName() + " " + datum.getOwner()).append(System.lineSeparator());
        }
        return sb.toString();
    }
}
