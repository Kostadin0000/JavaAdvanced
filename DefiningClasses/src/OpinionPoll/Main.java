package OpinionPoll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());

        List<Person> personList = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            String[] tokens = scanner.nextLine().split(" ");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            if (age>30){
            Person person = new Person(name,age);
            personList.add(person);

            }
        }


        personList.sort(Comparator.comparing(Person::getName));

        for (Person person : personList) {
            System.out.println(person.getName() + " - " + person.getAge());
        }

    }
}
