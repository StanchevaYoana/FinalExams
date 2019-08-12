import java.util.Scanner;

public class SoftUniReception {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int capacity = Integer.parseInt(scanner.nextLine()) + Integer.parseInt(scanner.nextLine()) + Integer.parseInt(scanner.nextLine());
        int students = Integer.parseInt(scanner.nextLine());

        int hours = 0;

        while (students > 0) {
            hours++;
            if (hours % 4 != 0) {
                students -= capacity;
            }
        }
        System.out.printf("Time needed: %dh.", hours);
    }
}
