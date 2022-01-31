package Fourth;

import java.util.Scanner;

public class Bee {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        String[][] teritorry = new String[n][];
        fillMatrix(teritorry, n, scanner);
        int row = 0;
        int col = 0;
        int flowers = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < teritorry[i].length; j++) {
                if (teritorry[i][j].equals("B")) {
                    row = i;
                    col = j;
                    break;
                }
            }
        }
        String command = scanner.nextLine();
        boolean isOut = false;
        while (!command.equals("End")) {
            if (isOut) {
                break;
            }
            if (command.equals("up")) {
                if (row - 1 >= 0) {
                    if (teritorry[row - 1][col].equals("O")) {
                        if (teritorry[row - 2][col].equals("f")) {
                            flowers++;
                            teritorry[row][col] = ".";
                            teritorry[row - 1][col] = ".";
                            teritorry[row - 2][col] = "B";
                            row -= 2;
                        } else {
                            teritorry[row][col] = ".";
                            teritorry[row -1 ][col] = ".";
                            teritorry[row - 2][col] = "B";
                            row -= 2;
                        }

                    } else if (teritorry[row - 1][col].equals("f")) {
                        flowers++;
                        teritorry[row][col] = ".";
                        teritorry[row - 1][col] = "B";
                        row -= 1;
                    } else {
                        teritorry[row][col] = ".";
                        teritorry[row - 1][col] = "B";
                        row -= 1;
                    }
                } else {
                    isOut = true;
                    teritorry[row][col] = ".";
                    continue;
                }

            } else if (command.equals("down")) {
                if (row + 1 < teritorry.length) {
                    if (teritorry[row + 1][col].equals("O")) {
                        if (teritorry[row + 2][col].equals("f")) {
                            flowers++;
                            teritorry[row][col] = ".";
                            teritorry[row + 1][col] = ".";
                            teritorry[row + 2][col] = "B";
                            row += 2;
                        } else {
                            teritorry[row][col] = ".";
                            teritorry[row + 1][col] = ".";
                            teritorry[row + 2][col] = "B";
                            row += 2;
                        }

                    } else if (teritorry[row + 1][col].equals("f")) {
                        flowers++;
                        teritorry[row][col] = ".";
                        teritorry[row + 1][col] = "B";
                        row += 1;
                    } else {
                        teritorry[row][col] = ".";
                        teritorry[row + 1][col] = "B";
                        row += 1;
                    }
                } else {
                    isOut = true;
                    teritorry[row][col] = ".";
                    continue;
                }
            } else if (command.equals("right")) {
                if (col + 1 < teritorry[row].length) {
                    if (teritorry[row][col + 1].equals("O")) {
                        if (teritorry[row][col + 2].equals("f")) {
                            flowers++;
                            teritorry[row][col] = ".";
                            teritorry[row][col + 1] = ".";
                            teritorry[row][col + 2] = "B";
                            col += 2;
                        } else {
                            teritorry[row][col] = ".";
                            teritorry[row][col + 1] = ".";
                            teritorry[row][col + 2] = "B";
                            col += 2;
                        }

                    } else if (teritorry[row][col + 1].equals("f")) {
                        flowers++;
                        teritorry[row][col] = ".";
                        teritorry[row][col + 1] = "B";
                        col += 1;
                    } else {
                        teritorry[row][col] = ".";
                        teritorry[row][col + 1] = "B";
                        col += 1;
                    }
                } else {
                    isOut = true;
                    teritorry[row][col] = ".";
                    continue;
                }
            } else if (command.equals("left")) {
                if (col - 1 >= 0) {
                    if (teritorry[row][col - 1].equals("O")) {
                        if (teritorry[row][col - 2].equals("f")) {
                            flowers++;
                            teritorry[row][col] = ".";
                            teritorry[row][col - 1] = ".";
                            teritorry[row][col - 2] = "B";
                            col -= 2;
                        } else {
                            teritorry[row][col] = ".";
                            teritorry[row][col - 1] = ".";
                            teritorry[row][col - 2] = "B";
                            col -= 2;
                        }

                    } else if (teritorry[row][col - 1].equals("f")) {
                        flowers++;
                        teritorry[row][col] = ".";
                        teritorry[row][col - 1] = "B";
                        col -= 1;
                    } else {
                        teritorry[row][col] = ".";
                        teritorry[row][col - 1] = "B";
                        col -= 1;
                    }
                } else {
                    isOut = true;
                    teritorry[row][col] = ".";
                    continue;
                }

            }
            command = scanner.nextLine();
        }
        if (isOut) {
            System.out.println("The bee got lost!");
        }
        if (flowers >= 5) {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", flowers);
        } else {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5 - flowers);
        }

        printMatrix(teritorry);
    }

    private static void printMatrix(String[][] teritorry) {
        for (String[] strings : teritorry) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println();
        }
    }

    private static void fillMatrix(String[][] teritorry, int n, Scanner scanner) {
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split("");
            teritorry[i] = tokens;

        }
    }
}
