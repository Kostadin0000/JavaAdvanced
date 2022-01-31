package Lab;

import java.util.ArrayDeque;
import java.util.Scanner;
public class Browser {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();

        ArrayDeque<String> browserHistory = new ArrayDeque<>(); // stack
        ArrayDeque<String> forward = new ArrayDeque<>(); // queue

        while (!line.equals("Home")){
            if (line.equals("back")){
                if (browserHistory.size() < 2){
                    System.out.println("no previous URLs");
                }else{
                    forward.addFirst(browserHistory.peek());
                    browserHistory.pop();
                    System.out.println(browserHistory.peek());
                }
            }else if (line.equals("forward")){
                if (forward.size() < 1){
                    System.out.println("no next URLs");
                }else{
                    System.out.println(forward.peek());
                    browserHistory.push(forward.pop());
                }

            }else{
                System.out.println(line);
                browserHistory.push(line);
                forward.clear();
            }
            line = scanner.nextLine();
        }
    }
}