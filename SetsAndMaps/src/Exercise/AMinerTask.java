package Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class AMinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();

        while (!input.equals("stop")) {
            int count = Integer.parseInt(scanner.nextLine());

            if (map.containsKey(input)) {
                map.put(input, map.get(input) + count);
            } else {
                map.put(input, count);
            }

            input = scanner.nextLine();
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }
}
