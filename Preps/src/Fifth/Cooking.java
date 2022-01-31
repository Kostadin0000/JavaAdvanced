package Fifth;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Cooking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> liquids = new ArrayDeque<>();
        ArrayDeque<Integer> ingredients = new ArrayDeque<>();
        int bread = 25;
        int cake = 50;
        int pastry = 75;
        int fruitPie = 100;
        int breadCount = 0;
        int cakeCount = 0;
        int pastryCount = 0;
        int fruitPieCount = 0;

        String[] tokens = scanner.nextLine().split(" ");
        for (int i = 0; i < tokens.length; i++) {
            liquids.offer(Integer.parseInt(tokens[i]));
        }
        tokens = scanner.nextLine().split(" ");
        for (int i = 0; i < tokens.length; i++) {
            ingredients.push(Integer.parseInt(tokens[i]));
        }

        while (!liquids.isEmpty() && !ingredients.isEmpty()) {
            if (liquids.peek() + ingredients.peek() == bread) {
                breadCount++;
                liquids.poll();
                ingredients.pop();
            } else if (liquids.peek() + ingredients.peek() == cake) {
                cakeCount++;
                liquids.poll();
                ingredients.pop();
            } else if (liquids.peek() + ingredients.peek() == pastry) {
                pastryCount++;
                liquids.poll();
                ingredients.pop();
            } else if (liquids.peek() + ingredients.peek() == fruitPie) {
                fruitPieCount++;
                liquids.poll();
                ingredients.pop();
            } else {
                liquids.poll();
                int toPush = ingredients.pop() + 3;
                ingredients.push(toPush);
            }
        }
        if (cakeCount >= 1 && breadCount >= 1 && fruitPieCount >= 1 && pastryCount >= 1) {
            System.out.println("Wohoo! You succeeded in cooking all the food!");
        }else{
            System.out.println("Ugh, what a pity! You didn't have enough materials to cook everything.");
        }

        if (liquids.isEmpty()){
            System.out.println("Liquids left: none");
        }else{
            System.out.print("Liquids left: ");
            System.out.print(liquids.poll());
            for (Integer liquid : liquids) {
                System.out.print(", " + liquid);
            }
            System.out.println();
        }
        if (ingredients.isEmpty()){
            System.out.println("Ingredients left: none");
        }else{
            System.out.print("Ingredients left: ");
            System.out.print(ingredients.pop());
            for (Integer ingredient : ingredients) {
                System.out.print(", " + ingredient);
            }
            System.out.println();
        }
        System.out.printf("Bread: %d%n",breadCount);
        System.out.printf("Cake: %d%n",cakeCount);
        System.out.printf("Fruit Pie: %d%n",fruitPieCount);
        System.out.printf("Pastry: %d",pastryCount);


    }
}
