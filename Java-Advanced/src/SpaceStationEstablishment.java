import java.util.Arrays;
import java.util.Scanner;


public class SpaceStationEstablishment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int starPower = 0;

        char[][] galaxy = new char[n][n];

        int[] ship = new int[2];

        for (int i = 0; i < galaxy.length; i++) {
            String[] input = scanner.nextLine().split("");
            for (int j = 0; j < input.length; j++) {
                galaxy[i][j] = input[j].charAt(0);
                if (galaxy[i][j] == 'S') {
                    ship[0] = i;
                    ship[1] = j;
                }
            }
        }

        boolean notVoid = false;

        while (true) {
            String command = scanner.nextLine();
            char value;
            switch (command) {
                case "left":
                    if (ship[1] - 1 >= 0) {
                        galaxy[ship[0]][ship[1]] = '-';
                        ship[1] = ship[1] - 1;
                        value = galaxy[ship[0]][ship[1]];
                        if (Character.isDigit(value)) {
                            starPower += value - '0';
                            galaxy[ship[0]][ship[1]] = 'S';
                        } else {
                            isABlackHole(galaxy, value, ship);
                        }
                    } else {
                        notVoid = true;
                    }
                    break;
                case "right":
                    if (ship[1] + 1 < galaxy[ship[0]].length) {
                        galaxy[ship[0]][ship[1]] = '-';
                        ship[1] = ship[1] + 1;
                        value = galaxy[ship[0]][ship[1]];
                        if (Character.isDigit(value)) {
                            starPower += value - '0';
                            galaxy[ship[0]][ship[1]] = 'S';
                        } else {
                            isABlackHole(galaxy, value, ship);
                        }
                    } else {
                        notVoid = true;
                    }
                    break;
                case "up":
                    if (ship[0] - 1 >= 0) {
                        galaxy[ship[0]][ship[1]] = '-';
                        ship[0] = ship[0] - 1;
                        value = galaxy[ship[0]][ship[1]];
                        if (Character.isDigit(value)) {
                            starPower += value - '0';
                            galaxy[ship[0]][ship[1]] = 'S';
                        } else {
                            isABlackHole(galaxy, value, ship);
                        }
                    } else {
                        notVoid = true;
                    }
                    break;
                case "down":
                    if (ship[0] + 1 < galaxy.length) {
                        galaxy[ship[0]][ship[1]] = '-';
                        ship[0] = ship[0] + 1;
                        value = galaxy[ship[0]][ship[1]];
                        if (Character.isDigit(value)) {
                            starPower += value - '0';
                            galaxy[ship[0]][ship[1]] = 'S';
                        }
                        isABlackHole(galaxy, value, ship);
                    } else {
                        notVoid = true;
                    }
                    break;
            }

            if (notVoid || starPower >= 50) {
                break;
            }
        }

        if (notVoid) {
            galaxy[ship[0]][ship[1]] = '-';
            System.out.println("Bad news, the spaceship went to the void.");
        } else {
            System.out.println("Good news! Stephen succeeded in collecting enough star power!");
        }

        System.out.println("Star power collected: " + starPower);

        for (char[] chars : galaxy) {
            System.out.println(Arrays.toString(chars).replaceAll("[\\[|\\], ]", ""));
        }
    }

    private static void isABlackHole(char[][] galaxy, char value, int[] ship) {
        if (value == 'O') {
            boolean isFind = false;
            for (int i = 0; i < galaxy.length; i++) {
                for (int j = 0; j < galaxy[i].length; j++) {
                    if (galaxy[i][j] == 'O'
                            && ship[0] != i
                            && ship[1] != j) {
                        galaxy[i][j] = 'S';
                        galaxy[ship[0]][ship[1]] = '-';
                        ship[0] = i;
                        ship[1] = j;
                        isFind = true;
                        break;
                    }
                }
                if (isFind) {
                    break;
                }
            }
        }
    }
}
