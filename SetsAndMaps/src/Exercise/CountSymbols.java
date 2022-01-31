package Exercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        TreeMap<Character, Integer> map = new TreeMap<>();

        for (int i = 0; i < input.length(); i++) {
            char symbol = input.charAt(i);

            if (map.containsKey(symbol)) {
                map.put(symbol, map.get(symbol) + 1);
            } else {
                map.put(symbol, 1);
            }
        }
        for (Map.Entry<Character, Integer> characterIntegerEntry : map.entrySet()) {
            System.out.println(characterIntegerEntry.getKey() + ": " + characterIntegerEntry.getValue() + " time/s");
        }
    }
}
