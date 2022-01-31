package RawData;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            //"<Model> <EngineSpeed> <EnginePower> <CargoWeight> <CargoType> <Tire1Pressure>
            // <Tire1Age> <Tire2Pressure> <Tire2Age> <Tire3Pressure> <Tire3Age>
            // <Tire4Pressure> <Tire4Age>
            String model = tokens[0];
            int speed = Integer.parseInt(tokens[1]);
            int power = Integer.parseInt(tokens[2]);
            int weight = Integer.parseInt(tokens[3]);
            String type = tokens[4];
            double tire1pressure = Double.parseDouble(tokens[5]);
            int tire1Age = Integer.parseInt(tokens[6]);
            double tire2pressure = Double.parseDouble(tokens[7]);
            int tire2Age = Integer.parseInt(tokens[8]);
            double tire3pressure = Double.parseDouble(tokens[9]);
            int tire3Age = Integer.parseInt(tokens[10]);
            double tire4pressure = Double.parseDouble(tokens[11]);
            int tire4Age = Integer.parseInt(tokens[12]);

            Tire tire = new Tire(tire1pressure, tire1Age, tire2pressure, tire2Age,
                    tire3pressure, tire3Age, tire4pressure, tire4Age);
            Cargo cargo = new Cargo(weight, type);
            Engine engine = new Engine(speed, power);
            Car car = new Car(model, engine, cargo, tire);

            cars.add(car);
        }
        String command = scanner.nextLine();

        if (command.equals("fragile")) {
            // tires under 1
            for (Car value : cars) {
                if (value.getTire().getTire1Pressure() < 1 ||
                        value.getTire().getTire2Pressure() < 1 ||
                        value.getTire().getTire3Pressure() < 1 ||
                        value.getTire().getTire4Pressure() < 1 && value.getCargo().getType().equals("fragile")) {
                    System.out.println(value.getModel());
                }
            }
        } else if (command.equals("flamable")) {
            //engine power > 250
            for (Car value : cars) {
                if (value.getEngine().getPower() > 250 && value.getCargo().getType().equals("flamable")) {
                    System.out.println(value.getModel());
                }
            }

        }
    }
}
