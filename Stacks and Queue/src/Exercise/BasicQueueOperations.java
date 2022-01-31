package Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int S = scanner.nextInt();
        int X = scanner.nextInt();

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {

            queue.offer(scanner.nextInt());

        }
        for (int i = 0; i < S; i++) {
            queue.poll();
        }

        if (queue.isEmpty()) {
            System.out.println(0);
            return;
        }

        if (queue.contains(X)) {
            System.out.println("true");
        } else {
            getMin(queue);
        }
    }

    private static void getMin(ArrayDeque<Integer> queue) {
        int max = Integer.MAX_VALUE;
        for (Integer integer : queue) {
            if (max > integer) {
                max = integer;
            }
        }
        System.out.println(max);
    }

}
