package Second;

import java.util.Scanner;

public class Revolt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isTrue = false;
        int n = Integer.parseInt(scanner.nextLine());
        int commands = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[n][];
        int row = 0;
        int col = 0;
        int finishRow = 0;
        int finishCol = 0;
        fillMatrix(matrix, n, scanner);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equals("f")) {
                    row = i;
                    col = j;

                } else if (matrix[i][j].equals("F")) {
                    finishRow = i;
                    finishCol = j;

                }
            }
        }


        for (int i = 0; i < commands; i++) {

            if (row == finishRow && col == finishCol) {
                matrix[row][col] = "f";
                isTrue = true;
                break;
            }
            String command = scanner.nextLine();
            if (command.equals("up")) {
                if (row - 1 >= 0) {
                    if (matrix[row - 1][col].equals("B")) {
                        if (row - 2 >= 0) {
                            matrix[row][col] = "-";
                            matrix[row - 2][col] = "f";
                            row -= 2;
                        } else {
                            matrix[matrix.length - 1][col] = "f";
                            row = matrix.length - 1;
                        }

                    } else if (matrix[row - 1][col].equals("T")) {
                        row = row;
                    } else {
                        matrix[row][col] = "-";
                        matrix[row - 1][col] = "f";
                        row -= 1;
                    }

                } else {
                    matrix[row][col] = "-";
                    matrix[matrix.length - 1][col] = "f";
                    row = matrix.length - 1;
                }


            } else if (command.equals("down")) {
                if (row + 1 < matrix.length) {
                    if (matrix[row + 1][col].equals("B")) {
                        if (row + 2 < matrix.length) {
                            matrix[row][col] = "-";
                            matrix[row + 2][col] = "f";
                            row += 2;
                        } else {
                            matrix[0][col] = "f";
                            row = 0;
                        }

                    } else if (matrix[row + 1][col].equals("T")) {
                        row = row;
                    } else {
                        matrix[row][col] = "-";
                        matrix[row + 1][col] = "f";
                        row += 1;
                    }

                } else {
                    matrix[row][col] = "-";
                    matrix[0][col] = "f";
                    row = 0;
                }
            } else if (command.equals("right")) {
                if (col + 1 < matrix[row].length) {
                    if (matrix[row][col + 1].equals("B")) {
                        if (col + 2 < matrix[row].length) {
                            matrix[row][col] = "-";
                            matrix[row][col + 2] = "f";
                            col += 2;
                        } else {
                            matrix[row][0] = "f";
                            col = 0;
                        }

                    } else if (matrix[row][col + 1].equals("T")) {
                        col = col;
                    } else {
                        matrix[row][col] = "-";
                        matrix[row][col + 1] = "f";
                        col += 1;
                    }

                } else {
                    matrix[row][col] = "-";
                    matrix[row][0] = "f";
                    col = 0;
                }

            } else if (command.equals("left")) {
                if (col - 1 >= 0) {
                    if (matrix[row][col - 1].equals("B")) {
                        if (col - 2 >= 0) {
                            matrix[row][col] = "-";
                            matrix[row][col - 2] = "f";
                            col -= 2;
                        } else {
                            matrix[row][col] = "-";
                            matrix[row][matrix[row].length - 1] = "f";
                            col = matrix[row].length - 1;
                        }

                    } else if (matrix[row][col - 1].equals("T")) {
                        col = col;
                    } else {
                        matrix[row][col] = "-";
                        matrix[row][col - 1] = "f";
                        col -= 1;
                    }

                } else {
                    matrix[row][col] = "-";
                    matrix[row][matrix[row].length - 1] = "f";
                    col = matrix[row].length - 1;
                }

            }
            if (row == finishRow && col == finishCol) {
                matrix[row][col] = "f";
                isTrue = true;
                break;
            }
        }
        if (isTrue) {
            System.out.println("Player won!");
            printMatrix(matrix, n);
        } else {
            System.out.println("Player lost!");
            printMatrix(matrix, n);
        }
    }

    private static void printMatrix(String[][] matrix, int n) {
        for (String[] strings : matrix) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println();
        }
    }

    private static void fillMatrix(String[][] matrix, int n, Scanner scanner) {
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("");
            matrix[i] = tokens;
        }
    }
}
