package Lab;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> children = new ArrayDeque<>();
        String input = scanner.nextLine();
        int n = Integer.parseInt(scanner.nextLine());
        String[] array = input.split(" ");
        for (int i = 0; i < array.length; i++) {
            children.offer(array[i]);
        }
        while(children.size() > 1) {
            for (int i = 1; i < n; i++) {
                String currentChild = children.poll();
                children.offer(currentChild);
            }

            String child = children.poll();
            System.out.println("Removed " + child);
        }

        String lastChild = children.poll();
        System.out.println("Last is " + lastChild);
    }
}

