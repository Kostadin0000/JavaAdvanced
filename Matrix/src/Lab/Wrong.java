package Lab;

import java.util.Scanner;

public class Wrong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[n][];
        int[][] matrix2 = fillMatrix(matrix, n, scanner);
        String[] tokens = scanner.nextLine().split(" ");
        int[][] matrix3 = new int[n][matrix2[0].length];


        int row = Integer.parseInt(tokens[0]);
        int col = Integer.parseInt(tokens[1]);

        int match = matrix2[row][col];
        int sum = 0;

        for (int rows = 0; rows < n; rows++) {
            sum = 0;
            for (int cols = 0; cols < matrix2[rows].length; cols++) {

                if (matrix2[rows][cols] == match) {


                    if (rows == 0) {
                        if (cols + 1 <= matrix2[rows].length - 1) {
                            if (matrix2[rows][cols + 1] != match) {
                                sum += matrix2[rows][cols + 1];
                            }
                        }
                        if (matrix2[rows + 1][cols] != match) {
                            sum += matrix2[rows + 1][cols];
                        }
                        if (cols > 0) {
                            if (matrix2[rows][cols - 1] != match) {
                                sum += matrix2[rows][cols - 1];
                            }
                        }
                        matrix3[rows][cols] = sum;
                        sum = 0;
                        continue;

                    } else {
                        if (cols > 0) {
                            if (matrix2[rows][cols - 1] != match) {
                                sum += matrix2[rows][cols - 1];

                            }
                        }
                        if (rows + 1 <= n - 1) {

                            if (matrix2[rows + 1][cols] != match) {
                                sum += matrix2[rows + 1][cols];
                            }
                        }
                        if (cols + 1 <= matrix2[rows].length - 1) {
                            if (matrix2[rows][cols + 1] != match) {
                                sum += matrix2[rows][cols + 1];
                            }
                        }
                        if (matrix2[rows - 1][cols] != match) {
                            sum += matrix2[rows - 1][cols];
                        }
                        matrix3[rows][cols] = sum;
                        sum = 0;
                        continue;
                    }

                }
                matrix3[rows][cols] = matrix2[rows][cols];


            }

        }
        printMatrix(matrix3, n);
    }

    private static void printMatrix(int[][] matrix3, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < matrix3[i].length; j++) {
                System.out.print(matrix3[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] fillMatrix(int[][] matrix, int n, Scanner scanner) {
        String[] tokens = scanner.nextLine().split(" ");
        int[][] matrix2 = new int[n][tokens.length];
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < tokens.length; j++) {
                matrix2[i][j] = Integer.parseInt(tokens[j]);
            }
            if (i < n - 1) {
                tokens = scanner.nextLine().split(" ");
            }

        }
        return matrix2;
    }
}
