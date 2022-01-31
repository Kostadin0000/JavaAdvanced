package Fourth;

import java.util.ArrayDeque;
import java.util.Scanner;

public class FlowerWreaths {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int goal = 0;
        int wreath = 15;
        int store = 0;

        ArrayDeque<Integer> roses = new ArrayDeque<>();
        ArrayDeque<Integer> lilies = new ArrayDeque<>();

        String[] tokens = scanner.nextLine().split(", ");
        for (int i = 0; i < tokens.length; i++) {
            lilies.push(Integer.parseInt(tokens[i]));
        }
        tokens = scanner.nextLine().split(", ");
        for (int i = 0; i < tokens.length; i++) {
            roses.offer(Integer.parseInt(tokens[i]));
        }

        while (!roses.isEmpty() && !lilies.isEmpty()) {
            if (goal == 5) {
                break;
            }
            if (roses.peek() + lilies.peek() == wreath) {
                roses.poll();
                lilies.pop();
                goal++;
                continue;
            } else if (roses.peek() + lilies.peek() > wreath) {
                int toPush = lilies.pop() - 2;
                lilies.push(toPush);
                continue;
            } else if (roses.peek() + lilies.peek() < wreath) {
                store += lilies.pop() + roses.poll();
                continue;
            }


        }
        if (goal == 5){
            System.out.printf("You made it, you are going to the competition with %d wreaths!",goal);
        }else{
            System.out.printf("You didn't make it, you need %d wreaths more!", 5 - (goal + store / wreath));
        }


    }
}
