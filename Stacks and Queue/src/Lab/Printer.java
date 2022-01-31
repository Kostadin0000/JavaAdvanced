package Lab;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Printer {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> queue = new ArrayDeque<>();

        String input = scanner.nextLine();

        while (!input.equals("print")){
            if (input.equals("cancel")){
                if (queue.isEmpty()){
                    System.out.println("Printer is on standby");
                }else{
                    System.out.println("Canceled" + " " + queue.pollFirst());
                }
            }else{
                queue.offer(input);
            }





            input = scanner.nextLine();
        }
        queue.forEach(System.out::println);
    }
}
