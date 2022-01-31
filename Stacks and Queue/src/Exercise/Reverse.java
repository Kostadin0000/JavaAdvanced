package Exercise;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Reverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = Arrays.stream(scanner.nextLine().split("\\s+"))
                        .mapToInt(e -> Integer.parseInt(e)).toArray();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < array.length; i++) {
            stack.push(array[i]);
        }

        for (Integer integer : stack) {
            System.out.print(integer + " ");
        }
    }
}
