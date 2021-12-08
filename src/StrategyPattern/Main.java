package StrategyPattern;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StrategyPattern.CompareByName compareByName = new StrategyPattern.CompareByName();
        Set<StrategyPattern.Person> studentsByName = new TreeSet<>(compareByName);

        StrategyPattern.CompareByAge compareByAge = new StrategyPattern.CompareByAge();
        Set<StrategyPattern.Person> studentsByAge = new TreeSet<>(compareByAge);

        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            StrategyPattern.Person person = new StrategyPattern.Person
                    (input.split("\\s+")[0],
                            Integer.parseInt(input.split("\\s+")[1]));
            studentsByName.add(person);
            studentsByAge.add(person);
        }
        studentsByName.forEach(System.out::println);
        studentsByAge.forEach(System.out::println);
    }
}
