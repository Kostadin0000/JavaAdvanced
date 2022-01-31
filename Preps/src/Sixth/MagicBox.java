package Sixth;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MagicBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> firstBox = new ArrayDeque<>();
        ArrayDeque<Integer> secondBox = new ArrayDeque<>();
        int storeSum = 0;
        String[] tokens = scanner.nextLine().split(" ");
        for (int i = 0; i < tokens.length; i++) {
            firstBox.offer(Integer.parseInt(tokens[i]));
        }
        tokens = scanner.nextLine().split(" ");
        for (int i = 0; i < tokens.length; i++) {
            secondBox.push(Integer.parseInt(tokens[i]));
        }

        while (!firstBox.isEmpty() && !secondBox.isEmpty()) {
            int sum = firstBox.peek() + secondBox.peek();
            if (sum % 2 == 0) {
                storeSum += firstBox.poll() + secondBox.pop();
            } else {
                firstBox.offer(secondBox.pop());
            }
            sum = 0;
        }
        if (firstBox.isEmpty()) {
            System.out.println("First magic box is empty.");
        }
        if (secondBox.isEmpty()) {
            System.out.println("Second magic box is empty.");
        }
        if (storeSum >= 90) {
            System.out.printf("Wow, your prey was epic! Value: %d", storeSum);
        } else {
            System.out.printf("Poor prey... Value: %d", storeSum);
        }

    }
}
