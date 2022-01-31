package Zero.healthyHeaven;

import java.util.ArrayList;
import java.util.List;

public class Salad {

    private String name;
    private List<Vegetable> products;
    private int sum;
    private int count;

    public Salad(String name) {
        this.name = name;
        this.products = new ArrayList<>();

    }

    public String getName() {
        return name;
    }

    public int getTotalCalories() {
        int sum = 0;
        for (Vegetable product : products) {
            sum += product.getCalories();
        }
        this.sum = sum;
        return sum;
    }

    public int getProductCount() {
        this.count = products.size();
        return products.size();
    }

    public void add(Vegetable product) {
        this.products.add(product);
   }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("* Salad %s is %d calories and have %d products:", this.getName(), this.getTotalCalories(), this.getProductCount()))
                .append(System.lineSeparator());
        for (Vegetable product : this.products) {
            sb.append(product.toString()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

}
