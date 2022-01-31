package Lab;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class MathPotato {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String [] children =scanner.nextLine().split(" ");
        int n=Integer.parseInt(scanner.nextLine());

        ArrayDeque<String> names= new ArrayDeque<>();
        Collections.addAll(names, children);

        int cycle=1;
        while (names.size()>1){
            for (int i = 1; i <n ; i++) {
                names.offer(names.poll());
            }
            if (isPrime(cycle)){
                System.out.println("Prime "+ names.peek());
            } else {
                System.out.println("Removed "+ names.poll());
            }


            cycle++;
        }
        System.out.println("Last is "+ names.poll());


    }

    private static boolean isPrime(int cycle) {
        if (cycle==1){
            return false;
        }
        for (int i = 2; i <cycle ; i++) {
            if (cycle%i ==0){
                return false;
            }
        }
        return true;
    }
}
