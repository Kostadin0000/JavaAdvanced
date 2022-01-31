package Exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        LinkedHashMap<String, String> map = new LinkedHashMap<>();

        while (!input.equals("stop")) {

            String email = scanner.nextLine();
            if (!email.endsWith("uk") && !email.endsWith("us") && !email.endsWith("com")) {
                map.put(input, email);
            }



            input = scanner.nextLine();
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

    }
}
