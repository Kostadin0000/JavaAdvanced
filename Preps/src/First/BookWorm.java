package First;

import java.util.Scanner;

public class BookWorm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        StringBuilder stringBuilder = new StringBuilder();
        String line = scanner.nextLine();
        stringBuilder.append(line);
        int n = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[n][];
        fillMatrix(matrix, n, scanner);
        int row = 0;
        int col = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j].equals("P")) {
                    row = i;
                    col = j;
                    break;
                }
            }
        }
        String command = scanner.nextLine();
        while (!command.equals("end")) {
            if (command.equals("up")) {
                if (row - 1 >= 0) {
                    if (!matrix[row - 1][col].equals("-")) {
                        stringBuilder.append(matrix[row - 1][col]);
                        matrix[row - 1][col] = "P";
                        matrix[row][col] = "-";
                        row -= 1;
                    } else {
                        matrix[row - 1][col] = "P";
                        matrix[row][col] = "-";
                        row -= 1;
                    }
                } else {
                    if (stringBuilder.length() > 0) {
                        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                    }
                }

            } else if (command.equals("down")) {
                if (row + 1 < matrix.length) {
                    if (!matrix[row + 1][col].equals("-")) {
                        stringBuilder.append(matrix[row + 1][col]);
                        matrix[row + 1][col] = "P";
                        matrix[row][col] = "-";
                        row += 1;
                    } else {
                        matrix[row + 1][col] = "P";
                        matrix[row][col] = "-";
                        row += 1;
                    }
                } else {
                    if (stringBuilder.length() > 0) {
                        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                    }
                }

            } else if (command.equals("right")) {
                if (col + 1 < matrix[row].length) {
                    if (!matrix[row][col + 1].equals("-")) {
                        stringBuilder.append(matrix[row][col + 1]);
                        matrix[row][col + 1] = "P";
                        matrix[row][col] = "-";
                        col += 1;
                    } else {
                        matrix[row][col + 1] = "P";
                        matrix[row][col] = "-";
                        col += 1;
                    }
                } else {
                    if (stringBuilder.length() > 0) {
                        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                    }
                }

            } else if (command.equals("left")) {
                if (col - 1 >= 0) {
                    if (!matrix[row][col - 1].equals("-")) {
                        stringBuilder.append(matrix[row][col - 1]);
                        matrix[row][col - 1] = "P";
                        matrix[row][col] = "-";
                        col -= 1;
                    } else {
                        matrix[row][col - 1] = "P";
                        matrix[row][col] = "-";
                        col -= 1;
                    }
                } else {
                    if (stringBuilder.length() > 0) {
                        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
                    }
                }


            }


            command = scanner.nextLine();
        }
        System.out.println(stringBuilder.toString());
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
