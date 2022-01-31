package Exam;

import java.util.Scanner;

public class Python {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[n][];
        String[] array = scanner.nextLine().split(", ");
        fillMatrix(matrix, n, scanner);
        boolean isKilled = false;
        int allFood = 0;
        int pythonLength = 0;
        int row = 0;
        int col = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equals("s")) {
                    row = i;
                    col = j;
                } else if (matrix[i][j].equals("f")) {
                    allFood++;
                }
            }
        }
        for (int i = 0; i < array.length; i++) {
            String command = array[i];
            if (isKilled){
                break;
            }

            if (command.equals("up")) {
                if (row - 1 >= 0) {
                    if (matrix[row - 1][col].equals("f")) {
                        pythonLength++;
                        allFood--;
                        matrix[row][col] = "*";
                        matrix[row - 1][col] = "s";
                        row -= 1;

                    } else if (matrix[row - 1][col].equals("*")) {
                        matrix[row][col] = "*";
                        matrix[row - 1][col] = "s";
                        row -= 1;
                    } else if (matrix[row - 1][col].equals("e")) {
                        isKilled = true;
                    }


                } else {
                    matrix[row][col] = "*";
                    row = matrix.length - 1;
                    if (matrix[row][col].equals("f")){
                        pythonLength++;
                        allFood--;
                        matrix[row][col] = "s";
                    }else{
                    matrix[row][col] = "s";
                    }
                }


            } else if (command.equals("down")) {
                if (row + 1 < matrix.length) {
                    if (matrix[row + 1][col].equals("f")) {
                        pythonLength++;
                        allFood--;
                        matrix[row][col] = "*";
                        matrix[row + 1][col] = "s";
                        row += 1;

                    } else if (matrix[row + 1][col].equals("*")) {
                        matrix[row][col] = "*";
                        matrix[row + 1][col] = "s";
                        row += 1;
                    } else if (matrix[row + 1][col].equals("e")) {
                        isKilled = true;
                    }


                } else {
                    matrix[row][col] = "*";
                    row = 0;
                    if (matrix[row][col].equals("f")){
                        pythonLength++;
                        allFood--;
                        matrix[row][col] = "s";
                    }else{
                        matrix[row][col] = "s";
                    }
                    matrix[row][col] = "s";
                }

            } else if (command.equals("right")) {
                if (col + 1 < matrix[row].length) {
                    if (matrix[row][col+1].equals("f")) {
                        pythonLength++;
                        allFood--;
                        matrix[row][col] = "*";
                        matrix[row ][col+1] = "s";
                        col += 1;

                    } else if (matrix[row][col+1].equals("*")) {
                        matrix[row][col] = "*";
                        matrix[row ][col+1] = "s";
                        col += 1;
                    } else if (matrix[row][col+1].equals("e")) {
                        isKilled = true;
                    }


                } else {
                    matrix[row][col] = "*";
                    col = 0;
                    if (matrix[row][col].equals("f")){
                        pythonLength++;
                        allFood--;
                        matrix[row][col] = "s";
                    }else{
                        matrix[row][col] = "s";
                    }
                    matrix[row][col] = "s";
                }

            } else if (command.equals("left")) {
                if (col - 1 >= 0) {
                    if (matrix[row][col-1].equals("f")) {
                        pythonLength++;
                        allFood--;
                        matrix[row][col] = "*";
                        matrix[row ][col-1] = "s";
                        col -= 1;

                    } else if (matrix[row][col-1].equals("*")) {
                        matrix[row][col] = "*";
                        matrix[row ][col-1] = "s";
                        col -= 1;
                    } else if (matrix[row][col-1].equals("e")) {
                        isKilled = true;
                    }


                } else {
                    matrix[row][col] = "*";
                    col = matrix[row].length - 1;
                    if (matrix[row][col].equals("f")){
                        pythonLength++;
                        allFood--;
                        matrix[row][col] = "s";
                    }else{
                        matrix[row][col] = "s";
                    }
                    matrix[row][col] = "s";
                }

            }
        }
        if (allFood == 0){
            System.out.printf("You win! Final python length is %d",pythonLength + 1);
        }else if (isKilled){
            System.out.println("You lose! Killed by an enemy!");
        }else{
            System.out.printf("You lose! There is still %d food to be eaten.",allFood);
        }


    }

    private static void fillMatrix(String[][] matrix, int n, Scanner scanner) {
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            matrix[i] = tokens;
        }
    }
}
