package Fifth;

import java.util.Scanner;

public class Selling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[n][];
        int exitRow = 0;
        int exitCol = 0;

        fillMatrix(matrix, n, scanner);

        int row = 0;
        int col = 0;
        int goal = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j].equals("S")) {
                    row = i;
                    col = j;
                    break;
                }
            }
        }
        boolean isOut = false;
        String command = scanner.nextLine();
        while (goal < 50) {
            if (isOut) {
                break;
            }
            if (command.equals("up")) {
                if (row - 1 >= 0) {
                    if (matrix[row - 1][col].equals("O")) {
                        matrix[row - 1][col] = "-";
                        for (int i = 0; i < n; i++) {
                            for (int j = 0; j < matrix[i].length; j++) {
                                if (matrix[i][j].equals("O")) {
                                    exitRow = i;
                                    exitCol = j;
                                    break;
                                }
                            }
                        }
                        matrix[row][col] = "-";
                        matrix[exitRow][exitCol] = "S";
                        row = exitRow;
                        col = exitCol;
                    } else if (!matrix[row - 1][col].equals("-")) {
                        goal += Integer.parseInt(matrix[row - 1][col]);
                        matrix[row][col] = "-";
                        matrix[row - 1][col] = "S";
                        row -= 1;
                    } else {
                        matrix[row][col] = "-";
                        matrix[row - 1][col] = "S";
                        row -= 1;
                    }

                } else {
                    isOut = true;
                    matrix[row][col] = "-";
                    continue;
                }


            } else if (command.equals("down")) {
                if (row + 1 < matrix.length) {
                    if (matrix[row + 1][col].equals("O")) {
                        matrix[row + 1][col] = "-";
                        for (int i = 0; i < n; i++) {
                            for (int j = 0; j < matrix[i].length; j++) {
                                if (matrix[i][j].equals("O")) {
                                    exitRow = i;
                                    exitCol = j;
                                    break;
                                }
                            }
                        }
                        matrix[row][col] = "-";
                        matrix[exitRow][exitCol] = "S";
                        row = exitRow;
                        col = exitCol;
                    } else if (!matrix[row + 1][col].equals("-")) {
                        goal += Integer.parseInt(matrix[row + 1][col]);
                        matrix[row][col] = "-";
                        matrix[row + 1][col] = "S";
                        row += 1;
                    } else {
                        matrix[row][col] = "-";
                        matrix[row + 1][col] = "S";
                        row += 1;
                    }

                } else {
                    isOut = true;
                    matrix[row][col] = "-";
                    continue;
                }

            } else if (command.equals("right")) {
                if (col + 1 < matrix[row].length) {
                    if (matrix[row][col + 1].equals("O")) {
                        matrix[row][col + 1] = "-";
                        for (int i = 0; i < n; i++) {
                            for (int j = 0; j < matrix[i].length; j++) {
                                if (matrix[i][j].equals("O")) {
                                    exitRow = i;
                                    exitCol = j;
                                    break;
                                }
                            }
                        }
                        matrix[row][col] = "-";
                        matrix[exitRow][exitCol] = "S";
                        row = exitRow;
                        col = exitCol;
                    } else if (!matrix[row][col + 1].equals("-")) {
                        goal += Integer.parseInt(matrix[row][col + 1]);
                        matrix[row][col] = "-";
                        matrix[row][col + 1] = "S";
                        col += 1;
                    } else {
                        matrix[row][col] = "-";
                        matrix[row][col + 1] = "S";
                        col += 1;
                    }

                } else {
                    isOut = true;
                    matrix[row][col] = "-";
                    continue;
                }


            } else if (command.equals("left")) {
                if (col - 1 >= 0) {
                    if (matrix[row][col - 1].equals("O")) {
                        matrix[row][col - 1] = "-";
                        for (int i = 0; i < n; i++) {
                            for (int j = 0; j < matrix[i].length; j++) {
                                if (matrix[i][j].equals("O")) {
                                    exitRow = i;
                                    exitCol = j;
                                    break;
                                }
                            }
                        }
                        matrix[row][col] = "-";
                        matrix[exitRow][exitCol] = "S";
                        row = exitRow;
                        col = exitCol;
                    } else if (!matrix[row][col - 1].equals("-")) {
                        goal += Integer.parseInt(matrix[row][col - 1]);
                        matrix[row][col] = "-";
                        matrix[row][col - 1] = "S";
                        col -= 1;
                    } else {
                        matrix[row][col] = "-";
                        matrix[row][col - 1] = "S";
                        col -= 1;
                    }

                } else {
                    isOut = true;
                    matrix[row][col] = "-";
                    continue;
                }

            }
            if (goal>=50){
                break;
            }


            command = scanner.nextLine();
        }
        if (isOut){
            System.out.println("Bad news, you are out of the bakery.");
        }
        if (goal >= 50){
            System.out.println("Good news! You succeeded in collecting enough money!");
        }
        System.out.printf("Money: %d%n",goal);
        printMatrix(matrix,n);

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
