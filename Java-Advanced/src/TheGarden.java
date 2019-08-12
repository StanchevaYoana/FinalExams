import java.util.Arrays;
import java.util.Scanner;

public class TheGarden {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = Integer.parseInt(scanner.nextLine());

        String[][] garden = new String[rows][];

        for (int i = 0; i < garden.length; i++) {
            garden[i] = scanner.nextLine().split(" ");
        }
        int carrots = 0;
        int potatoes = 0;
        int lettuce = 0;
        int harmed = 0;

        String input;
        while (!"End of Harvest".equals(input = scanner.nextLine())) {

            String[] command = input.split(" ");
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
                                    String value = garden[row][col];
                                    if (Character.isAlphabetic(value.charAt(0))) {
                                        harmed++;
                                        garden[row][col] = " ";
                                    }
                                    row -= 2;
                                }
                                break;

                            case "down":
                                while (row < garden.length) {
                                    String value = garden[row][col];
                                    if (Character.isAlphabetic(value.charAt(0))) {
                                        harmed++;
                                        garden[row][col] = " ";
                                    }
                                    row += 2;
                                }
                                break;

                            case "left":
                                while (col >= 0) {
                                    String value = garden[row][col];
                                    if (Character.isAlphabetic(value.charAt(0))) {
                                        harmed++;
                                        garden[row][col] = " ";
                                    }
                                    col -= 2;
                                }
                                break;

                            case "right":
                                while (col < garden[row].length) {
                                    String value = garden[row][col];
                                    if (Character.isAlphabetic(value.charAt(0))) {
                                        harmed++;
                                        garden[row][col] = " ";
                                    }
                                    col += 2;
                                }
                                break;
                        }

                        break;
                }
            }
        }
        printMatrix(garden);

        System.out.println("Carrots: " + carrots);
        System.out.println("Potatoes: " + potatoes);
        System.out.println("Lettuce: " + lettuce);
        System.out.println("Harmed vegetables: " + harmed);
    }

    private static void printMatrix(String[][] garden) {
        for (String[] chars : garden) {
            System.out.println(Arrays.toString(chars).replaceAll("[\\[|\\],]", ""));
        }
    }
}
