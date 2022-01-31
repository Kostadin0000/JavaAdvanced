package Second;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Lootbox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> firstBox = new ArrayDeque<>();
        ArrayDeque<Integer> secondBox = new ArrayDeque<>();

        String[] tokens1 = scanner.nextLine().split(" ");
        for (String s : tokens1) {
            firstBox.offer(Integer.parseInt(s));
        }
        tokens1 = scanner.nextLine().split(" ");
        for (String s : tokens1) {
            secondBox.push(Integer.parseInt(s));
        }
        List<Integer> sumItems = new ArrayList<>();
        int sum = 0;
        while (!firstBox.isEmpty() && !secondBox.isEmpty()) {
            sum = 0;
            sum = firstBox.peek() + secondBox.peek();
            if (sum % 2 == 0) {
                sumItems.add(sum);
                firstBox.poll();
                secondBox.pop();
                continue;
            } else {
                if (!secondBox.isEmpty()) {
                    firstBox.addLast(secondBox.pop());
                    continue;
                } else {
                    break;
                }
            }


        }

        if (firstBox.isEmpty()){
            System.out.println("First lootbox is empty");
        }
        if (secondBox.isEmpty()){
            System.out.println("Second lootbox is empty");
        }
        int finalSum = 0;
        for (Integer sumItem : sumItems) {
            finalSum += sumItem;
        }
        if (finalSum >= 100) {
            System.out.printf("Your loot was epic! Value: %d",finalSum);
        }else{
            System.out.printf("Your loot was poor... Value: %d",finalSum);
        }


    }
}
