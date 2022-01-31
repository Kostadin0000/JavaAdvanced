package Seventh;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Bouquets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> daffodils = new ArrayDeque<>();
        ArrayDeque<Integer> tulips = new ArrayDeque<>();

        int bouquet = 15;
        int goal = 5;
        int bouquetCount = 0;
        int storeSum = 0;

        String[] tokens = scanner.nextLine().split(", ");
        for (int i = 0; i < tokens.length; i++) {
            tulips.push(Integer.parseInt(tokens[i]));
        }
        tokens = scanner.nextLine().split(", ");
        for (int i = 0; i < tokens.length; i++) {
            daffodils.offer(Integer.parseInt(tokens[i]));
        }


        while (!tulips.isEmpty() && !daffodils.isEmpty()) {
            if (tulips.peek() + daffodils.peek() == bouquet) {
                bouquetCount++;
                tulips.pop();
                daffodils.poll();
            } else if (tulips.peek() + daffodils.peek() > bouquet) {
                int toPush = tulips.pop() - 2;
                tulips.push(toPush);

            } else {
                storeSum += daffodils.poll() + tulips.pop();
            }


        }
        if (bouquetCount >= goal) {
            System.out.printf("You made it! You go to the competition with %d bouquets!",bouquetCount);
        }else{
            System.out.printf("You failed... You need more %d bouquets.",goal - (bouquetCount + storeSum / 15));
        }
    }
}
