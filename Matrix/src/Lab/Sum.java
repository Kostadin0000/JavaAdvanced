package Lab;

import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] input = scanner.nextLine().split(", ");

        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);
        int[][] matrix = new int[rows][cols];
        int sum = 0;
        for (int i = 0; i < rows; i++) {
            String[] tokens = scanner.nextLine().split(", ");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = Integer.parseInt(tokens[j]);
                sum += matrix[i][j];
            }
        }
        System.out.println(rows);
        System.out.println(cols);
        System.out.println(sum);
    }
}
