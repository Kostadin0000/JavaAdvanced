package StrategyPattern;


import java.util.Comparator;

public class CompareByAge implements Comparator<Person> {
    public int compare(Person a, Person b){
        return a.getAge() - b.getAge();
    }
}
