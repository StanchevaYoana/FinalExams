import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class HelenAbduction {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int parisEnergy = Integer.parseInt(reader.readLine());
        int sizeOfMatrix = Integer.parseInt(reader.readLine());

        String[][] field = new String[sizeOfMatrix][];
        for (int i = 0; i < field.length; i++) {
            field[i] = reader.readLine().split("");
        }
        int[] parisPosition = findIndexes(field);

        int parisRow = parisPosition[0];
        int parisCol = parisPosition[1];


        field[parisRow][parisCol] = "-";

        while (true) {
            String[] enemySpawn = reader.readLine().split("\\s+");

            String parisDirection = enemySpawn[0];
            int enemyRow = Integer.parseInt(enemySpawn[1]);
            int enemyCol = Integer.parseInt(enemySpawn[2]);

            field[enemyRow][enemyCol] = "S";
            parisEnergy--;

            switch (parisDirection) {
                case "up":
                    if (parisRow - 1 >= 0) {
                        parisRow--;
                    }
                    break;
                case "down":
                    if (parisRow + 1 < sizeOfMatrix) {
                        parisRow++;
                    }
                    break;
                case "left":
                    if (parisCol - 1 >= 0) {
                        parisCol--;
                    }
                    break;
                case "right":
                    if (parisCol + 1 < sizeOfMatrix) {
                        parisCol++;
                    }
                    break;

            }

            if (field[parisRow][parisCol].equals("H")) {
                field[parisRow][parisCol] = "-";
                System.out.printf("Paris has successfully abducted Helen! Energy left: %d%n", parisEnergy);
                break;
            }
            if (parisEnergy <= 0) {
                field[parisRow][parisCol] = "X";
                System.out.printf("Paris died at %d;%d.%n", parisRow, parisCol);
                break;
            }
            if (field[parisRow][parisCol].equals("S")) {
                if (parisEnergy - 2 > 0) {
                    parisEnergy -= 2;
                    field[parisRow][parisCol] = "-";
                } else {
                    field[parisRow][parisCol] = "X";
                    System.out.printf("Paris died at %d;%d.%n", parisRow, parisCol);
                    break;
                }
            }
        }
        for (String[] chars : field) {
            System.out.println(Arrays.toString(chars).replaceAll("[\\[|\\], ]", ""));
        }
    }

    private static int[] findIndexes(String[][] field) {

        int[] indexes = new int[2];

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                if (field[i][j].equals("P")) {
                    indexes[0] = i;
                    indexes[1] = j;
                    return indexes;
                }
            }
        }
        return indexes;
    }
}