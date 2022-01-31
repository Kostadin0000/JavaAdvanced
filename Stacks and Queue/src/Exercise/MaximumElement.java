package Exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<Integer> stack = new ArrayDeque<>();


        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("\\s+");
            String firstMarker = tokens[0];

            if (firstMarker.equals("1")){
                int pushNumber = Integer.parseInt(tokens[1]);
                stack.push(pushNumber);
            }else if(firstMarker.equals("2")){
                stack.pop();

            }else if(firstMarker.equals("3")){
                getMax(stack);
            }
        }
    }

    private static void getMax(ArrayDeque<Integer> stack) {
        int max = Integer.MIN_VALUE;
        for (Integer integer : stack) {
            if (integer>max){
                max = integer;
            }
        }
        System.out.println(max);
    }
}
