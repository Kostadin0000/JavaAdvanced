package Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class BasicStackOperations {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int S = scanner.nextInt();
        int X = scanner.nextInt();

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {

            stack.push(scanner.nextInt());

        }
        for (int i = 0; i < S; i++) {
            stack.pop();
        }

        if (stack.isEmpty()){
            System.out.println(0);
            return;
        }

        if (stack.contains(X)) {
            System.out.println("true");
        } else {
getMin(stack);
        }
    }

    private static void getMin(ArrayDeque<Integer> stack) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < stack.size(); i++) {
            int a = stack.peek();
            stack.pop();
            if (min > a){
                min = a;
            }
        }
        System.out.println(min);
    }
}
