package CarSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, Engine> engines = new LinkedHashMap<>();
        List<Car> set = new ArrayList<>();
        Engine engine = null;
        Car car = null;

        for (int i = 0; i < n; i++) {

            String[] tokens = scanner.nextLine().split("\\s+");
            String model = tokens[0];
            int power = Integer.parseInt(tokens[1]);
            int displacement = 0;
            String efficiency = "n/a";

            if (tokens.length == 4) {
                displacement = Integer.parseInt(tokens[2]);
                efficiency = tokens[3];
                engine = new Engine(model, power, displacement, efficiency);
                engines.put(model,engine);
            } else if (tokens.length == 3) {
                try {
                    displacement = Integer.parseInt(tokens[2]);
                    engine = new Engine(model, power, displacement);
                    engines.put(model, engine);
                } catch (NumberFormatException e) {
                    efficiency = (tokens[2]);
                    engine = new Engine(model, power, efficiency);
                    engines.put(model, engine);
                }
                engine = new Engine(model, power, displacement, efficiency);
                engines.put(model, engine);
            } else {
                engine = new Engine(model, power, displacement, efficiency);
                engines.put(model, engine);
            }
        }

        int m = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < m; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String model = tokens[0];
            String engine2 = tokens[1];
            if (tokens.length == 4) {

                int weight = Integer.parseInt(tokens[2]);
                String color = tokens[3];
                car = new Car(model, engines.get(engine2), weight, color);
                set.add(car);

            } else if (tokens.length == 3) {

                try {
                    int weight = Integer.parseInt(tokens[2]);
                    car = new Car(model, engines.get(engine2), weight);
                    set.add(car);
                } catch (NumberFormatException e) {
                    String color = (tokens[2]);
                    car = new Car(model, engines.get(engine2), color);
                    set.add(car);
                }

            } else if (tokens.length == 2) {
                car = new Car(model, engines.get(engine2));
                set.add(car);
            }

        }

        for (Car car1 : set) {
            System.out.printf("%s: %n", car1.getModel());
            System.out.printf("%s: %n", car1.getEngine().getModel());
            System.out.printf("Power: %d%n", engines.get(car1.getEngine().getModel()).getPower());
            if (engines.get(car1.getEngine().getModel()).getDisplacement() == 0) {
                System.out.printf("Displacement: n/a%n");
            } else {
                System.out.printf("Displacement: %d%n", engines.get(car1.getEngine().getModel()).getDisplacement());
            }
            System.out.printf("Efficiency: %s%n", engines.get(car1.getEngine().getModel()).getEfficiency());
            if (car1.getWeight() == 0) {
                System.out.printf("Weight: n/a%n");
            } else {
                System.out.printf("Weight: %d%n", car1.getWeight());
            }
            System.out.printf("Color: %s%n", car1.getColor());
        }

    }
}
