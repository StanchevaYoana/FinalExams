import java.util.Scanner;

public class AsciiSumator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char first = scanner.nextLine().charAt(0);
        char second = scanner.nextLine().charAt(0);

        int sum = 0;

        String string = scanner.nextLine();
        for (int i = 0; i < string.length(); i++) {
            char symbol = string.charAt(i);
            if ((int) symbol > (int) first && (int) symbol < (int) second){
                sum += symbol;
            }
        }
        System.out.println(sum);
    }
}
