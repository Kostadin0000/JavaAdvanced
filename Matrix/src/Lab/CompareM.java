package Lab;

import java.util.Scanner;

public class CompareM {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean isTrue = false;
        String[] input = scanner.nextLine().split("\\s+");
        int rows = Integer.parseInt(input[0]);
        int cols = Integer.parseInt(input[1]);

        int[][] matrix = new int[rows][cols];

        for (int row = 0; row < rows; row++) {

            String[] inputTokens = scanner.nextLine().split("\\s+");

            for (int column = 0; column < cols; column++) {

                matrix[row][column] = Integer.parseInt(inputTokens[column]);
            }
        }

        String[] input2 = scanner.nextLine().split("\\s+");
        int rows2 = Integer.parseInt(input2[0]);
        int cols2 = Integer.parseInt(input2[1]);

        int[][] matrix2 = new int[rows2][cols2];

        for (int row2 = 0; row2 < rows2; row2++) {

            String[] inputTokens2 = scanner.nextLine().split("\\s+");

            for (int column2 = 0; column2 < cols2; column2++) {

                matrix2[row2][column2] = Integer.parseInt(inputTokens2[column2]);
            }
        }

        if (cols != cols2 || rows != rows2) {
            System.out.println("not equal");
            return;
        } else {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (matrix[i][j] == matrix2[i][j]) {
                        isTrue = true;
                    }else{
                        isTrue = false;
                    }
                }
            }
        }
        if (isTrue) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
        }
    }

}
