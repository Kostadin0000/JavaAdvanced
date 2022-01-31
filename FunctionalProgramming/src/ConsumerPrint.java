import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class ConsumerPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //Function <приема, връща>
        //Consumer <приема> -> void
        //Supplier <връща>
        //Predicate<приема> -> връща true/false
        //BiFunction<приема1, приема2, връща>


        String input = scanner.nextLine();
        String[] names = input.split("\\s+");

        //приема колекция -> принтира
        Consumer<String[]> printString = array -> {
            for (String name : names) {
                System.out.println(name);
            }
        };

        printString.accept(names);

    }
}
