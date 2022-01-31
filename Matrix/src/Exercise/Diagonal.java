package Exercise;

import java.util.Scanner;

public class Diagonal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[n][n];

        fillTheMatrix(matrix,n,scanner);

        int sumMainDiagonal = 0;
        int sumSecondDiagonal = 0;

        for (int rows = 0; rows < n; rows++) {
            for (int cols = 0; cols < n; cols++) {
                if (rows == cols){
                    sumMainDiagonal += matrix[rows][cols];
                }
            }
        }
        for (int rows = 0; rows < n; rows++) {
            for (int cols = 0; cols < n; cols++) {
                if (cols == n - rows - 1){
                    sumSecondDiagonal += matrix[rows][cols];
                }
            }
        }
        System.out.println(Math.abs(sumMainDiagonal-sumSecondDiagonal));

    }

    private static void fillTheMatrix(int[][] matrix, int n, Scanner scanner) {
        for (int rows = 0; rows < n; rows++) {
            for (int cols = 0; cols < n; cols++) {
                matrix[rows][cols] = scanner.nextInt();
            }
            if (rows < n - 1 ){
            scanner.nextLine();
            }
        }
    }
}
