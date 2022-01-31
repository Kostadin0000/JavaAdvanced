package Sixth;

import java.util.Arrays;
import java.util.Scanner;

public class Bomb {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        String[][] bombSite = new String[n][];
        String[] array = scanner.nextLine().split(",");
        fillMatrix(bombSite, n, scanner);

        int row = 0;
        int col = 0;
        int allBombs = 0;
        int bombCount = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < bombSite[i].length; j++) {
                if (bombSite[i][j].equals("s")) {
                    row = i;
                    col = j;
                } else if (bombSite[i][j].equals("B")) {
                    allBombs++;
                }
            }
        }
        String command;
        boolean isOut = false;

        for (int i = 0; i < array.length; i++) {

            command = array[i];

            if (command.equals("up")) {
                if (row - 1 >= 0) {
                    if (bombSite[row - 1][col].equals("B")) {
                        bombCount++;
                        bombSite[row][col] = "+";
                        bombSite[row - 1][col] = "s";
                        System.out.println("You found a bomb!");
                        row -= 1;
                    } else if (bombSite[row - 1][col].equals("+")) {
                        bombSite[row][col] = "+";
                        bombSite[row - 1][col] = "s";
                        row -= 1;
                    } else if (bombSite[row - 1][col].equals("e")) {
                        isOut = true;
                        //   bombSite[row - 1][col] = "s";
                        // row -= 1;
                    }
                }
            } else if (command.equals("down")) {
                if (row + 1 < bombSite.length) {
                    if (bombSite[row + 1][col].equals("B")) {
                        bombCount++;
                        bombSite[row][col] = "+";
                        bombSite[row + 1][col] = "s";
                        System.out.println("You found a bomb!");
                        row += 1;
                    } else if (bombSite[row + 1][col].equals("+")) {
                        bombSite[row][col] = "+";
                        bombSite[row + 1][col] = "s";
                        row += 1;
                    } else if (bombSite[row + 1][col].equals("e")) {
                        // bombSite[row + 1][col] = "s";
                        //  row += 1;
                        isOut = true;
                    }
                }
            } else if (command.equals("right")) {
                if (col + 1 < bombSite[row].length) {
                    if (bombSite[row][col + 1].equals("B")) {
                        bombCount++;
                        bombSite[row][col] = "+";
                        bombSite[row][col + 1] = "s";
                        System.out.println("You found a bomb!");
                        col += 1;

                    } else if (bombSite[row][col + 1].equals("+")) {
                        bombSite[row][col] = "+";
                        bombSite[row][col + 1] = "s";
                        col += 1;

                    } else if (bombSite[row][col + 1].equals("e")) {
                        // bombSite[row][col + 1] = "s";
                        // col += 1;
                        isOut = true;
                    }
                }
            } else if (command.equals("left")) {
                if (col - 1 >= 0) {
                    if (bombSite[row][col - 1].equals("B")) {
                        bombCount++;
                        bombSite[row][col] = "+";
                        bombSite[row][col - 1] = "s";
                        System.out.println("You found a bomb!");
                        col -= 1;
                    } else if (bombSite[row][col - 1].equals("+")) {
                        bombSite[row][col] = "+";
                        bombSite[row][col - 1] = "s";
                        col -= 1;

                    } else if (bombSite[row][col - 1].equals("e")) {
                        //bombSite[row][col - 1] = "s";
                        isOut = true;
                        //col-=1;
                    }
                }
            }
            if (isOut) {
                break;
            }
            if (bombCount == allBombs) {
                break;
            }
        }

        if (isOut) {
            System.out.printf("END! %d bombs left on the field", allBombs - bombCount);
        } else if (bombCount == allBombs) {
            System.out.println("Congratulations! You found all bombs!");
        } else {
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)",
                    allBombs - bombCount, row, col);
        }


    }

    private static void fillMatrix(String[][] bombSite, int n, Scanner scanner) {
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            bombSite[i] = tokens;
        }
    }
}
