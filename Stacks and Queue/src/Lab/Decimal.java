package Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Decimal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int input = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        if (input == 0 ){
            System.out.println(0);
            return;
        }

        while (input != 0) {
            stack.push(input % 2);
            input /= 2;
        }
        stack.forEach(System.out::print);
    }
}
