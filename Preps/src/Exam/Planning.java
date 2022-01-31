package Exam;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Planning {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> tasks = new ArrayDeque<>();
        ArrayDeque<Integer> threads = new ArrayDeque<>();

        String[] tokens = scanner.nextLine().split(", ");
        for (String token : tokens) {
            tasks.push(Integer.parseInt(token));
        }
        tokens = scanner.nextLine().split(" ");
        for (String token : tokens) {
            threads.offer(Integer.parseInt(token));
        }

        int valueToKill = Integer.parseInt(scanner.nextLine());

        while (!tasks.isEmpty() && !threads.isEmpty()) {
            if (threads.peek() >= tasks.peek()) {
                if (tasks.peek() == valueToKill) {
                    break;
                } else {

                    threads.poll();
                    tasks.pop();
                }
            } else {
                if (tasks.peek() == valueToKill) {
                    break;
                } else {
                    threads.poll();
                }
            }


        }
        System.out.printf("Thread with value %d killed task %d%n",threads.peek(),valueToKill);
        for (Integer thread : threads) {
            System.out.print(thread + " ");
        }

    }
}
