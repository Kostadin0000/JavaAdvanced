package Zero;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class TheGarden {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = Integer.parseInt(scanner.nextLine());
        String[][] matrix = new String[n][];
        fillMatrix(matrix, n, scanner);
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        int harmed = 0;
        map.put("C", 0);
        map.put("L", 0);
        map.put("P", 0);

        String input = scanner.nextLine();

        while (!input.equals("End of Harvest")) {
            String[] splitted = input.split(" ");
            String command = splitted[0];
            if (command.equals("Harvest")) {
                int row = Integer.parseInt(splitted[1]);
                int col = Integer.parseInt(splitted[2]);
                if ((row >= 0 && row < matrix.length) && (col >= 0 && col < matrix[row].length)) {
                    if (matrix[row][col].equals("C")) {
                        if (map.containsKey("C")) {
                            map.put("C", map.get("C") + 1);
                        }
                    } else if (matrix[row][col].equals("P")) {
                        if (map.containsKey("P")) {
                            map.put("P", map.get("P") + 1);
                        }
                    } else if (matrix[row][col].equals("L")) {
                        if (map.containsKey("L")) {
                            map.put("L", map.get("L") + 1);
                        }
                    } else if (matrix[row][col].equals(" ")) {
                        input = scanner.nextLine();
                        continue;
                    }
                    matrix[row][col] = " ";
                }
            } else if (command.equals("Mole")) {
                int row = Integer.parseInt(splitted[1]);
                int col = Integer.parseInt(splitted[2]);
                String direction = splitted[3];
                if ((row >= 0 && row < matrix.length) && (col >= 0 && col < matrix[row].length)) {
                    if (direction.equals("up")) {
                        for (int rows = row; rows >= 0; rows -= 2) {
                            if (matrix[rows][col].equals(" ")) {
                            } else {
                                matrix[rows][col] = " ";
                                harmed++;
                            }
                        }
                    } else if (direction.equals("down")) {
                        for (int i = row; i < matrix.length; i += 2) {
                            if (matrix[i][col].equals(" ")) {
                            } else {
                                matrix[i][col] = " ";
                                harmed++;
                            }
                        }
                    } else if (direction.equals("left")) {
                        for (int cols = col; cols >= 0; cols -= 2) {
                            if (matrix[row][cols].equals(" ")) {
                            } else {
                                matrix[row][cols] = " ";
                                harmed++;
                            }
                        }

                    } else if (direction.equals("right")) {
                        for (int cols = col; cols < matrix[row].length; cols += 2) {
                            if (matrix[row][cols].equals(" ")) {
                            } else {
                                matrix[row][cols] = " ";
                                harmed++;
                            }
                        }
                    }
                }

            }


            input = scanner.nextLine();
        }
        printMatrix(matrix);
        System.out.printf("Carrots: %d%n", map.get("C"));
        System.out.printf("Potatoes: %d%n", map.get("P"));
        System.out.printf("Lettuce: %d%n", map.get("L"));
        System.out.println("Harmed vegetables: " + harmed);
    }

    private static void printMatrix(String[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }


    private static void fillMatrix(String[][] matrix, int n, Scanner scanner) {
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            matrix[i] = tokens;
        }
    }
}
