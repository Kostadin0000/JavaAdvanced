package Lab;

import java.util.Scanner;

public class Diagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            for (int j = 0; j < tokens.length; j++) {
                matrix[i][j] = Integer.parseInt(tokens[j]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    System.out.print(matrix[i][j] + " ");
                }
            }
        }
        System.out.println();
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == n - j - 1) {
                    if (i == 0) {
                        System.out.println(matrix[i][j]);
                    } else {
                        System.out.print(matrix[i][j] + " ");
                    }
                }
            }
        }

    }
}
