package Lab;

import java.util.Scanner;

public class Positions {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(" ");

        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = Integer.parseInt(tokens[j]);
            }
        }
        int match = Integer.parseInt(scanner.nextLine());
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == match) {
                    count++;
                    System.out.println(i + " " + j);
                }
            }
        }

        if (count == 0) {
            System.out.println("not found");
        }
    }
}
