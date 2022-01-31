package Third;

import java.util.ArrayDeque;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Bombs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> bombEffect = new ArrayDeque<>();
        ArrayDeque<Integer> bombCasing = new ArrayDeque<>();
        int daturaBombCount = 0;
        int cherryBombCount = 0;
        int smokeBombCount = 0;
        boolean isTrue = false;
        String[] tokens = scanner.nextLine().split(", ");
        for (String token : tokens) {
            bombEffect.offer(Integer.parseInt(token));
        }
        String[] tokens2 = scanner.nextLine().split(", ");
        for (String token : tokens2) {
            bombCasing.push(Integer.parseInt(token));
        }

        while (!bombEffect.isEmpty() && !bombCasing.isEmpty()) {
            if (daturaBombCount >= 3 && cherryBombCount >= 3 && smokeBombCount >= 3) {
                isTrue = true;
                break;
            }
            if (bombCasing.peek() + bombEffect.peek() == 40) {
                daturaBombCount++;
                bombCasing.pop();
                bombEffect.poll();
                continue;

            } else if (bombCasing.peek() + bombEffect.peek() == 60) {
                cherryBombCount++;
                bombCasing.pop();
                bombEffect.poll();
                continue;
            } else if (bombCasing.peek() + bombEffect.peek() == 120) {
                smokeBombCount++;
                bombCasing.pop();
                bombEffect.poll();
                continue;
            } else {
                int push = bombCasing.pop() - 5;
                bombCasing.push(push);
                continue;
            }


        }
        if (isTrue) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        if (bombEffect.isEmpty()) {
            System.out.println("Bomb Effects: empty");
        } else {
            System.out.print("Bomb Effects: ");
            System.out.print(bombEffect.poll());
            for (Integer integer : bombEffect) {
                System.out.print(", " + integer);
            }
            System.out.println();
        }
        if (bombCasing.isEmpty()) {
            System.out.println("Bomb Casings: empty");
        } else {
            System.out.print("Bomb Casings: ");
            System.out.print(bombCasing.pop());
            for (Integer integer : bombCasing) {
                System.out.print(", " + integer);
            }
            System.out.println();
        }
        System.out.printf("Cherry Bombs: %d%n", cherryBombCount);
        System.out.printf("Datura Bombs: %d%n", daturaBombCount);
        System.out.printf("Smoke Decoy Bombs: %d", smokeBombCount);

    }
}
