package Lab;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;


public class Voina {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for (int i = 0; i < numbers.length; i++) {
            set.add(numbers[i]);
        }

        int[] numbers2 = Arrays.stream(scanner.nextLine()
                .split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        LinkedHashSet<Integer> set2 = new LinkedHashSet<>();
        for (int i = 0; i < numbers2.length; i++) {
            set2.add(numbers2[i]);
        }
        for (int i = 0; i < 50; i++) {

            int number = 0;
            for (Integer integer : set) {
                number = integer;
                set.remove(integer);
                break;
            }
            int number2 = 0;
            for (Integer integer : set2) {
                number2 = integer;
                set2.remove(integer);
                break;
            }
            if (number > number2) {
                set.add(number);
                set.add(number2);
            } else if (number2 > number){
                set2.add(number);
                set2.add(number2);
            }else{
                set.add(number);
                set2.add(number2);
            }
            if (set.isEmpty()){
                break;
            }else if (set2.isEmpty()){
                break;
            }
        }
        if (set.isEmpty()){
            System.out.println("Second player win!");
            return;
        }else if (set2.isEmpty()){
            System.out.println("First player win!");
            return;
        }


        if (set.size() < set2.size()){
            System.out.println("Second player win!");
        }else if (set.size() > set2.size()){
            System.out.println("First player win!");
        }else {
            System.out.println("Draw!");
        }

    }
}
