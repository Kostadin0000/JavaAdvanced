package StrategyPattern;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

       // CompareByName compareByName = new CompareByName();
        Set<Person> studentsByName = new TreeSet<>(new CompareByName());

       // CompareByAge compareByAge = new CompareByAge();
        Set<Person> studentsByAge = new TreeSet<>(new CompareByAge());

        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            Person person = new Person
                    (input.split("\\s+")[0],
                            Integer.parseInt(input.split("\\s+")[1]));
            studentsByName.add(person);
            studentsByAge.add(person);
        }
        studentsByName.forEach(System.out::println);
        System.out.println();
        studentsByAge.forEach(System.out::println);
    }
}
