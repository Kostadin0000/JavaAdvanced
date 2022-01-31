package Zero;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Salad {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        ArrayDeque<String> queue = new ArrayDeque<>();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int tomato = 80;
        int carrot = 136;
        int lettuce = 109;
        int potato = 215;


        String[] input1 = scanner.nextLine().split(" ");
        String[] input2 = scanner.nextLine().split(" ");

        for (int index = 0; index < input1.length; index++) {
            String offer = input1[index];
            if (offer.equals("potato") || offer.equals("tomato") ||
                    offer.equals("lettuce") || offer.equals("carrot")) {
                queue.offer(offer);
            }
        }
        for (int index = 0; index < input2.length; index++) {
            stack.push(Integer.parseInt(input2[index]));
        }

        int salad = stack.pop();
        int save = salad;

        while (salad > 0) {
            String polled = queue.poll();
            if (polled.equals("tomato")) {
                salad -= tomato;
            } else if (polled.equals("potato")) {
                salad -= potato;
            } else if (polled.equals("lettuce")) {
                salad -= lettuce;
            } else if (polled.equals("carrot")) {
                salad -= carrot;
            }

            if (salad <= 0) {
                list.add(save);
                if (!stack.isEmpty() && !queue.isEmpty()) {
                    salad = stack.pop();
                    save = salad;
                } else {
                    break;
                }
            }
            if (queue.isEmpty()) {
                list.add(save);
                break;
            }


        }

        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
        System.out.println();
        for (Integer integer : stack) {
            System.out.print(integer + " ");
        }
        for (String s : queue) {
            System.out.print(s + " ");
        }

    }
}
