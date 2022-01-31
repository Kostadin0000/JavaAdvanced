package Third;

import java.util.Scanner;

public class Snake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[n][];
        int row = 0;
        int col = 0;
        int bunkerRow = 0;
        int bunkerCol = 0;
        int foodEaten = 0;
        boolean inBounds = false;
        fillMatrix(matrix, n, scanner);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equals("S")) {
                    row = i;
                    col = j;
                }
            }
        }
        while (!inBounds && foodEaten < 10) {

            String command = scanner.nextLine();
            if (command.equals("up")) {
                if (row - 1 >= 0) {
                    if (matrix[row - 1][col].equals("*")) {
                        foodEaten++;
                        matrix[row][col] = ".";
                        matrix[row - 1][col] = "S";
                        row -= 1;
                        continue;
                    } else if (matrix[row - 1][col].equals("B")) {
                        matrix[row][col] = ".";
                        matrix[row - 1][col] = ".";
                        for (int i = 0; i < n; i++) {
                            for (int j = 0; j < matrix[i].length; j++) {
                                if (matrix[i][j].equals("B")) {
                                    bunkerRow = i;
                                    bunkerCol = j;
                                    break;
                                }
                            }
                        }
                        row = bunkerRow;
                        col = bunkerCol;
                        matrix[row][col] = "S";
                    } else {
                        matrix[row][col] = ".";
                        matrix[row - 1][col] = "S";
                        row -= 1;
                    }
                } else {
                    matrix[row][col] = ".";
                    inBounds = true;
                    continue;
                }
            } else if (command.equals("down")) {
                if (row + 1 < matrix.length) {
                    if (matrix[row + 1][col].equals("*")) {
                        foodEaten++;
                        matrix[row][col] = ".";
                        matrix[row + 1][col] = "S";
                        row += 1;
                        continue;
                    } else if (matrix[row + 1][col].equals("B")) {
                        matrix[row][col] = ".";
                        matrix[row + 1][col] = ".";
                        for (int i = 0; i < n; i++) {
                            for (int j = 0; j < matrix[i].length; j++) {
                                if (matrix[i][j].equals("B")) {
                                    bunkerRow = i;
                                    bunkerCol = j;
                                    break;
                                }
                            }
                        }
                        row = bunkerRow;
                        col = bunkerCol;
                        matrix[row][col] = "S";
                    } else {
                        matrix[row][col] = ".";
                        matrix[row + 1][col] = "S";
                        row += 1;
                    }
                } else {
                    matrix[row][col] = ".";
                    inBounds = true;
                    continue;
                }

            } else if (command.equals("right")) {
                if (col + 1 < matrix[row].length) {
                    if (matrix[row][col + 1].equals("*")) {
                        foodEaten++;
                        matrix[row][col] = ".";
                        matrix[row][col + 1] = "S";
                        col += 1;
                        continue;
                    } else if (matrix[row][col + 1].equals("B")) {
                        matrix[row][col] = ".";
                        matrix[row][col + 1] = ".";
                        for (int i = 0; i < n; i++) {
                            for (int j = 0; j < matrix[i].length; j++) {
                                if (matrix[i][j].equals("B")) {
                                    bunkerRow = i;
                                    bunkerCol = j;
                                    break;
                                }
                            }
                        }
                        row = bunkerRow;
                        col = bunkerCol;
                        matrix[row][col] = "S";
                    } else {
                        matrix[row][col] = ".";
                        matrix[row][col + 1] = "S";
                        col += 1;
                    }
                } else {
                    matrix[row][col] = ".";
                    inBounds = true;
                    continue;
                }

            } else if (command.equals("left")) {
                if (col - 1 >= 0) {
                    if (matrix[row][col - 1].equals("*")) {
                        foodEaten++;
                        matrix[row][col] = ".";
                        matrix[row][col - 1] = "S";
                        col -= 1;
                        continue;
                    } else if (matrix[row][col - 1].equals("B")) {
                        matrix[row][col] = ".";
                        matrix[row][col - 1] = ".";
                        for (int i = 0; i < n; i++) {
                            for (int j = 0; j < matrix[i].length; j++) {
                                if (matrix[i][j].equals("B")) {
                                    bunkerRow = i;
                                    bunkerCol = j;
                                    break;
                                }
                            }
                        }
                        row = bunkerRow;
                        col = bunkerCol;
                        matrix[row][col] = "S";
                    } else {
                        matrix[row][col] = ".";
                        matrix[row][col - 1] = "S";
                        col -= 1;
                    }
                } else {
                    matrix[row][col] = ".";
                    inBounds = true;
                    continue;
                }

            }

        }
        if (inBounds) {
            System.out.println("Game over!");
        } else {
            System.out.println("You won! You fed the snake.");
        }

        System.out.printf("Food eaten: %d%n", foodEaten);
        printMatrix(matrix, n);

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
