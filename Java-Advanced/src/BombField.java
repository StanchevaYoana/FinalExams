import java.util.Scanner;

public class BombField {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        String[] tokens = scanner.nextLine().split(",");
        String[][] field = new String[n][n];

        for (int i = 0; i < field.length; i++) {
            field[i] = scanner.nextLine().split("\\s+");
        }
        int[] playerPosition = findPlayerPosition(field);
        int bombsOnTheField = countAllBobs(field);

        boolean endOfGame = false;

        for (String direction : tokens) {
            int row = playerPosition[0];
            int col = playerPosition[1];

            switch (direction) {
                case "up":
                    if (row - 1 >= 0) {
                        playerPosition[0] -= 1;
                    }
                    break;
                case "down":
                    if (row + 1 < field.length) {
                        playerPosition[0] += 1;
                    }
                    break;
                case "left":
                    if (col - 1 >= 0) {
                        playerPosition[1] -= 1;
                    }
                    break;
                case "right":
                    if (col + 1 < field.length) {
                        playerPosition[1] += 1;
                    }
                    break;
            }

            switch (field[playerPosition[0]][playerPosition[1]]) {
                case "e":
                    endOfGame = true;
                    break;
                case "B":
                    System.out.println("You found a bomb!");
                    field[playerPosition[0]][playerPosition[1]] = "+";
                    bombsOnTheField--;
                    break;
            }
            if (endOfGame || bombsOnTheField == 0) {
                break;
            }
        }
        if (bombsOnTheField == 0) {
            System.out.println("Congratulations! You found all bombs!");
        } else if (endOfGame) {
            System.out.printf("END! %d bombs left on the field\n", bombsOnTheField);
        } else {
            System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)", bombsOnTheField, playerPosition[0], playerPosition[1]);
        }
    }

    private static int countAllBobs(String[][] field) {
        int bombs = 0;
        for (String[] strings : field) {
            for (int j = 0; j < field.length; j++) {
                if (("B").equals(strings[j])) {
                    bombs++;
                }
            }
        }
        return bombs;
    }

      private static int[] findPlayerPosition(String[][] field) {
        int[] positions = new int[2];
        boolean positionFound = false;
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j].equals("s")) {
                    positions[0] = i;
                    positions[1] = j;
                    positionFound = true;
                    break;
                }
            }
            if (positionFound) break;
        }
        return positions;
    }
}
