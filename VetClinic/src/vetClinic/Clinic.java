package vetClinic;

import java.util.ArrayList;
import java.util.List;

public class Clinic {
    private int capacity;
    private List<Pet> data;

    public Clinic(int capacity) {
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Pet pet) {
        if (data.size() < capacity) {
            this.data.add(pet);
        }
    }

    public boolean remove(String name) {
        for (int i = 0; i < this.data.size(); i++) {
            if (this.data.get(i).getName().equals(name)) {
                this.data.remove(i);
                return true;
            }
        }
        return false;
    }

    public Pet getPet(String name, String owner) {
        for (Pet datum : this.data) {
            if (datum.getName().equals(name) && datum.getOwner().equals(owner)) {
                return datum;
            }
        }
        return null;
    }

    public Pet getOldestPet() {
        int max = Integer.MIN_VALUE;
        Pet pet = null;
        for (Pet datum : data) {
            if (datum.getAge() > max) {
                max = datum.getAge();
                pet = datum;
            }
        }
        return pet;
    }
    public int getCount(){
        return this.data.size();
    }
    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        sb.append("The clinic has the following patients:").append(System.lineSeparator());
        for (Pet datum : data) {
            sb.append(datum.getName() + " " + datum.getOwner()).append(System.lineSeparator());
        }
        return sb.toString();
    }


}
