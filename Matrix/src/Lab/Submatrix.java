package Lab;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Submatrix {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[][] matrix = fillMatrix(reader);

        int maxSum = Integer.MIN_VALUE;
        int row = 0;
        int col = 0;
        for (int rows = 0; rows < matrix.length-1; rows++) {
            for (int cols = 0; cols < matrix[0].length-1; cols++) {
                int sum = 0;
                sum += matrix[rows][cols] + matrix[rows][cols+1];
                sum += matrix[rows+1][cols] + matrix[rows+1][cols+1];


                if (sum > maxSum){
                    maxSum = sum;
                    row = rows;
                    col = cols;
                }
            }
        }



        for (int i = row; i < row+2; i++) {
            for (int j = col; j < col+2; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(maxSum);


    }

    private static int[][] fillMatrix(BufferedReader reader) throws IOException {
        String[] rowsCols = reader.readLine().split(", ");
        int rows = Integer.parseInt(rowsCols[0]);
        int cols = Integer.parseInt(rowsCols[1]);

        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] numsInput = reader.readLine().split(", ");
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = Integer.parseInt(numsInput[col]);
            }
        }
        return matrix;

    }
}