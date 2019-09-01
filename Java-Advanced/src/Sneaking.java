import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Sneaking {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int rows = Integer.parseInt(reader.readLine());
        boolean heroIsAlive = true;
        boolean enemyIsKilled = false;

        String[][] matrix = new String[rows][];
        int[] hero = new int[2];
        boolean playerFound = false;

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = reader.readLine().split("");
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                if (matrix[i][j].equals("S")) {
                    hero[0] = i;
                    hero[1] = j;
                    playerFound = true;
                    break;
                }
            }
            if (playerFound) {
                break;
            }
        }
        String commands = reader.readLine();
        int counter = 0;

        while (true) {

            int heroRow = hero[0];
            int heroCol = hero[1];
            enemyMoves(matrix);
            heroIsAlive = checkIfHeroIsAlive(matrix, heroRow, heroCol);

            if (!heroIsAlive) {
                break;
            }
            heroMovement(matrix, commands.charAt(counter), hero);
            enemyIsKilled = checkIfNikoladzeIsKilled(matrix, hero[0]);
            if (enemyIsKilled) {
                break;
            }
            counter++;
        }
        if (enemyIsKilled){
            System.out.println("Nikoladze killed!");
        } else {
            System.out.printf("Sam died at %d, %d%n", hero [0], hero [1]);
        }

        for (String[] strings : matrix) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println();
        }
    }

    private static boolean checkIfNikoladzeIsKilled(String[][] matrix, int hero) {
        for (int i = 0; i < matrix[hero].length; i++) {
            if (matrix[hero][i].equals("N")) {
                matrix[hero][i] = "X";
                return true;
            }
        }
        return false;
    }

    private static void heroMovement(String[][] matrix, char charAt, int[] hero) {
        int heroRow = hero[0];
        int heroCol = hero[1];
        matrix[heroRow][heroCol] = ".";
        switch (charAt) {
            case 'U':
                heroRow -= 1;
                break;
            case 'D':
                heroRow += 1;
                break;
            case 'L':
                heroCol -= 1;
                break;
            case 'R':
                heroCol += 1;
                break;
        }
        matrix[heroRow][heroCol] = "S";
        hero[0] = heroRow;
        hero[1] = heroCol;
    }

    private static boolean checkIfHeroIsAlive(String[][] gameField, int rowOfPlayer, int colOfPlayer) {
        for (int i = colOfPlayer + 1; i < gameField[rowOfPlayer].length; i++) {
            if (gameField[rowOfPlayer][i].equals("d")) {
                gameField[rowOfPlayer][colOfPlayer] = "X";
                return false;
            }
        }
        for (int i = 0; i < colOfPlayer; i++) {
            if (gameField[rowOfPlayer][i].equals("b")) {
                gameField[rowOfPlayer][colOfPlayer] = "X";
                return false;
            }
        }
        return true;
    }


    private static void enemyMoves(String[][] matrix) {
        for (int j = 0; j < matrix.length; j++) {
            for (int k = 0; k < matrix[j].length; k++) {
                if (matrix[j][k].equals("b")) {
                    if (k + 1 > matrix[j].length - 1) {
                        matrix[j][k] = "d";
                        break;
                    } else {
                        matrix[j][k] = ".";
                        matrix[j][k + 1] = "b";
                        break;
                    }
                }
                if (matrix[j][k].equals("d")) {
                    if (k - 1 < 0) {
                        matrix[j][k] = "b";
                        break;
                    } else {
                        matrix[j][k] = ".";
                        matrix[j][k - 1] = "d";
                        break;
                    }
                }
            }
        }
    }
}