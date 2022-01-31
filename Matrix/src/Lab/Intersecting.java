package Lab;

import java.util.Scanner;

public class Intersecting {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());

        char[][] matrix = new char[rows][cols];
        char[][] matrix2 = new char[rows][cols];
        char[][] matrix3 = new char[rows][cols];

        for (int row = 0; row < rows; row++) {

            String[] inputTokens = scanner.nextLine().split("\\s+");

            for (int column = 0; column < cols; column++) {

                matrix[row][column] = inputTokens[column].charAt(0);
            }
        }

        for (int row = 0; row < rows; row++) {

            String[] inputTokens = scanner.nextLine().split("\\s+");

            for (int column = 0; column < cols; column++) {

                matrix2[row][column] = inputTokens[column].charAt(0);
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == matrix2[i][j]){
                    matrix3[i][j] = matrix2[i][j];
                }else{
                    matrix3[i][j] = '*';
                }

            }
        }


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix3[i][j] + " ");
            }
            System.out.println();
        }
    }
}
