package Lab;

import java.util.LinkedHashSet;
import java.util.Scanner;

public class Parking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashSet<String> set = new LinkedHashSet<>();

        String input = scanner.nextLine();
        while (!input.equals("END")){
            String command = input.split(", ")[0];
            String number = input.split(", ")[1];
            if (command.equals("IN")){
                set.add(number);
            }else if (command.equals("OUT")){
                set.remove(number);
            }


            input = scanner.nextLine();
        }
        for (String s : set) {
            System.out.println(s);
        }
        if (set.isEmpty()){
            System.out.println("Parking Lot is Empty");
        }
    }
}
