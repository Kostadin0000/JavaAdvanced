package Exercise;

import java.util.Scanner;

public class MatrixShuffle {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(tokens[0]);
        int cols = Integer.parseInt(tokens[1]);

        String[][] matrix = new String[rows][cols];

        fillMatrix(scanner, rows, cols, matrix);

        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] tokens2 = input.split(" ");
            if ((tokens2.length != 5) || (!tokens2[0].equals("swap"))) {
                System.out.println("Invalid input!");
                input = scanner.nextLine();
                continue;
            } else  {
                int row1 = Integer.parseInt(tokens2[1]);
                int col1 = Integer.parseInt(tokens2[2]);
                int row2 = Integer.parseInt(tokens2[3]);
                int col2 = Integer.parseInt(tokens2[4]);

                if (row1 >= rows || row1 < 0 || row2 < 0
                        || col1 < 0 || col2 < 0 || row2 >= rows
                        || col1 >= cols || col2 >= cols) {
                    System.out.println("Invalid input!");
                    input = scanner.nextLine();
                    continue;
                }
                String swap1 = matrix[row1][col1];
                String swap2 = matrix[row2][col2];
                matrix[row1][col1] = swap2;
                matrix[row2][col2] = swap1;
                printMatrix(matrix, rows, cols);
            }
            input = scanner.nextLine();
        }
    }
    private static void printMatrix(String[][] matrix, int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }


    private static void fillMatrix(Scanner scanner, int rows, int cols, String[][] matrix) {
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = scanner.next();
            }
            scanner.nextLine();
        }
    }

}
