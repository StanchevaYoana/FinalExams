import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TronRacers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(reader.readLine());

        String[][] matrix = new String[size][size];
        int[] firstPlayerPositions = new int[2];
        int[] secondPlayerPositions = new int[2];

        for (int i = 0; i < matrix.length; i++) {
            String input = reader.readLine();
            for (int j = 0; j < input.length(); j++) {
                matrix[i][j] = String.valueOf(input.charAt(j));
                if (matrix[i][j].equals("f")) {
                    firstPlayerPositions[0] = i;
                    firstPlayerPositions[1] = j;
                }
                if (matrix[i][j].equals("s")) {
                    secondPlayerPositions[0] = i;
                    secondPlayerPositions[1] = j;
                }
            }
        }

        while (true) {
            String[] command = reader.readLine().split("\\s+");
            String firstCommand = command[0];
            String secondCommand = command[1];
            movement(firstCommand, firstPlayerPositions, matrix);

            if (isPlayerDead(firstPlayerPositions, matrix)) {
                break;
            }

            movement(secondCommand, secondPlayerPositions, matrix);
            if (isPlayerDead(secondPlayerPositions, matrix)) {
                break;
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    private static boolean isPlayerDead(int[] playerPositions, String[][] matrix) {
        return matrix[playerPositions[0]][playerPositions[1]].equals("x");
    }

    private static void movement(String commandOfPlayer, int[] playerPositions, String[][] matrix) {
        int rowOfPlayer = playerPositions[0];
        int colOfPlayer = playerPositions[1];
        String symbol = matrix[rowOfPlayer][colOfPlayer];
        switch (commandOfPlayer) {
            case "up":
                if (rowOfPlayer - 1 >= 0) {
                    rowOfPlayer -= 1;
                } else {
                    rowOfPlayer = matrix.length - 1;
                }
                break;
            case "down":
                if (rowOfPlayer + 1 < matrix.length) {
                    rowOfPlayer += 1;
                } else {
                    rowOfPlayer = 0;
                }
                break;
            case "right":
                if (colOfPlayer + 1 < matrix.length) {
                    colOfPlayer += 1;
                } else {
                    colOfPlayer = 0;
                }
                break;
            case "left":
                if (colOfPlayer - 1 < 0) {
                    colOfPlayer = matrix.length - 1;
                } else {
                    colOfPlayer -= 1;
                }
                break;

        }
        if (matrix[rowOfPlayer][colOfPlayer].equalsIgnoreCase("*")) {
            matrix[rowOfPlayer][colOfPlayer] = symbol;
        } else {
            matrix[rowOfPlayer][colOfPlayer] = "x";
        }
        playerPositions[0] = rowOfPlayer;
        playerPositions[1] = colOfPlayer;
    }
}
