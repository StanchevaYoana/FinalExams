
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Sneaking2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        String[][] field = new String[n][];

        for (int i = 0; i < field.length; i++) {
            field[i] = reader.readLine().split("");
        }
        int[] enemyPosition = findPosition(field, "N");
        int[] playerPosition = findPosition(field, "S");

        boolean playerIsAlive = true;
        String[] strings = reader.readLine().split("");

        for (String direction : strings) {
            enemyMoves(field);
            playerIsAlive = checkIsPlayerAlive(field, playerPosition);
            if (!playerIsAlive) {
                break;
            }
            field[playerPosition[0]][playerPosition[1]] = ".";
            switch (direction) {
                case "U":
                    playerPosition[0] -= 1;
                    break;
                case "D":
                    playerPosition[0] += 1;
                    break;
                case "L":
                    playerPosition[1] -= 1;
                    break;
                case "R":
                    playerPosition[1] += 1;
                    break;
            }
            field[playerPosition[0]][playerPosition[1]] = "S";

            if (playerPosition[0] == enemyPosition[0]) {
                field[enemyPosition[0]][enemyPosition[1]] = "X";
                break;
            }

        }
        if (playerIsAlive) {
            System.out.println("Nikoladze killed!");
        } else {
            System.out.printf("Sam died at %d, %d%n", playerPosition[0], playerPosition[1]);
            field[playerPosition[0]][playerPosition[1]] = "X";
        }
        for (String[] value : field) {
            Arrays.stream(value).forEach(System.out::print);
            System.out.println();
        }
    }


    private static boolean checkIsPlayerAlive(String[][] field, int[] playerPosition) {
        int colOfPlayer = playerPosition [1];
        int rowOfPlayer = playerPosition [0];
        for (int i = colOfPlayer + 1; i < field[rowOfPlayer].length; i++) {
            if (field[rowOfPlayer][i].equals("d")) {
                field[rowOfPlayer][colOfPlayer] = "X";
                return false;
            }
        }
        for (int i = 0; i < colOfPlayer; i++) {
            if (field[rowOfPlayer][i].equals("b")) {
                field[rowOfPlayer][colOfPlayer] = "X";
                return false;
            }
        }
        return true;
    }
    //d -> left
    //b -right
    private static void enemyMoves(String[][] field) {
        for (int j = 0; j < field.length; j++) {
            for (int k = 0; k < field[j].length; k++) {
                if (field[j][k].equals("b")) {
                    if (k + 1 > field[j].length - 1) {
                        field[j][k] = "d";
                        break;
                    } else {
                        field[j][k] = ".";
                        field[j][k + 1] = "b";
                        break;
                    }
                }
                if (field[j][k].equals("d")) {
                    if (k - 1 < 0) {
                        field[j][k] = "b";
                        break;
                    } else {
                        field[j][k] = ".";
                        field[j][k - 1] = "d";
                        break;
                    }
                }
            }
        }
    }

    private static int[] findPosition(String[][] field, String name) {
        int[] targetPosition = new int[2];
        boolean targetFound = false;

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (name.equals(field[i][j])) {
                    targetPosition[0] = i;
                    targetPosition[1] = j;
                    targetFound = true;
                    break;
                }
            }
            if (targetFound) {
                break;
            }
        }
        return targetPosition;
    }
}
