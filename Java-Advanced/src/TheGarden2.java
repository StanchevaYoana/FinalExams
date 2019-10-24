import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TheGarden2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        String[][] garden = new String[n][];

        for (int i = 0; i < garden.length; i++) {
            garden[i] = reader.readLine().split("\\s+");
        }

        int carrots = 0;
        int potatoes = 0;
        int lettuce = 0;
        int harmedVeggie = 0;

        String input;

        while (!"End of Harvest".equals(input = reader.readLine())) {
            String[] command = input.split("\\s+");

            int row = Integer.parseInt(command[1]);
            int col = Integer.parseInt(command[2]);

            if (row >= 0 && row < garden.length && col >= 0 && col < garden[row].length) {

                switch (command[0]) {
                    case "Harvest":
                        switch (garden[row][col]) {
                            case "C":
                                carrots++;
                                break;
                            case "P":
                                potatoes++;
                                break;
                            case "L":
                                lettuce++;
                                break;
                        }
                        garden[row][col] = " ";
                        break;
                    case "Mole":
                            switch (command[3]) {
                                case "up":
                                    while (row >= 0) {
                                        harmedVeggie += harmedVeggie(garden, row, col);
                                        row -= 2;
                                    }
                                    break;
                                case "down":
                                    while (row < garden.length ) {
                                        harmedVeggie += harmedVeggie(garden, row, col);
                                        row += 2;
                                    }
                                    break;
                                case "left":
                                    while (col >= 0) {
                                        harmedVeggie += harmedVeggie(garden, row, col);
                                        col -= 2;
                                    }
                                    break;
                                case "right":
                                    while (col < garden[row].length) {
                                        harmedVeggie += harmedVeggie(garden, row, col);
                                        col += 2;
                                    }
                                    break;
                        }
                        break;
                }
            }
        }
        printGarden(garden);
        System.out.println(String.format("Carrots: %d%nPotatoes: %d%nLettuce: %d%nHarmed vegetables: %d"
                , carrots
                , potatoes
                , lettuce
                , harmedVeggie));
    }

    private static void printGarden(String[][] garden) {
        for (String[] chars : garden) {
            System.out.println(Arrays.toString(chars).replaceAll("[\\[|\\],]", ""));
        }
    }

    private static int harmedVeggie(String[][] garden, int row, int col) {

        int harmedVeggie = 0;
        if (!garden[row][col].equals(" ")) {
            garden[row][col] = " ";
            harmedVeggie++;
        }
        return harmedVeggie;
    }
}
