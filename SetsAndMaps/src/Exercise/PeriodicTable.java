package Exercise;

import java.util.Scanner;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        TreeSet<String> set = new TreeSet<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            if (input.length == 1) {
                set.add(input[0]);
            } else {
                for (int j = 0; j < input.length; j++) {
                    set.add(input[j]);
                }
            }
        }

        for (String s : set) {
            System.out.print(s + " ");
        }
    }
}
