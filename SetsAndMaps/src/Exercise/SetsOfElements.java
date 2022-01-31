package Exercise;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tokens = scanner.nextLine().split(" ");
        int n = Integer.parseInt(tokens[0]);
        int m = Integer.parseInt(tokens[1]);

        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        LinkedHashSet<Integer> set2 = new LinkedHashSet<>();
        LinkedHashSet<Integer> set3 = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(scanner.nextLine()));
        }

        for (int i = 0; i < m; i++) {
            set2.add(Integer.parseInt(scanner.nextLine()));

        }
        for (Integer integer : set) {
            if (set2.contains(integer)) {
                set3.add(integer);
            }
        }

        for (Integer integer : set3) {
            System.out.print(integer + " ");
        }

    }
}
